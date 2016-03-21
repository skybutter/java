package sb.bbdlws;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bloomberg.datalic.dlps.Data;
import com.bloomberg.datalic.dlps.Fields;
import com.bloomberg.datalic.dlps.GetDataHeaders;
import com.bloomberg.datalic.dlps.Instrument;
import com.bloomberg.datalic.dlps.InstrumentData;
import com.bloomberg.datalic.dlps.Instruments;
import com.bloomberg.datalic.dlps.PerSecurityWS;
import com.bloomberg.datalic.dlps.RetrieveGetDataRequest;
import com.bloomberg.datalic.dlps.RetrieveGetDataResponse;
import com.bloomberg.datalic.dlps.SubmitGetDataRequest;
import com.bloomberg.datalic.dlps.SubmitGetDataResponse;

public class BlpDlwsProcessor {

	private static Logger logger = Logger.getLogger(BlpDlwsProcessor.class.getName()); 
	private static final Object lock = new Object();
	private static BlpDlwsProcessor processor;
	private static final int EXCEPTION_STATUS_ID = -1;
	private static final int HTTP_CONNECTION_FAIL = -2;
	private static int firstPollFrequency = 20000;				// in milliseconds
	private static int subsequentPollFrequency = 5000;			// in milliseconds
	private static int pollFrequency = firstPollFrequency;		// in milliseconds

	private static final String ERROR_SYSTEM = "System Issue";
	private static final String ERROR_TIMEOUT = "Forced Timeout";
	public static final int BLOOMBERG_THREAD_FORCED_TIMEOUT_MS = 300000;		// in milliseconds
	public static final String LOG_PREFIX = "BLPDLWS";
	
	private static final int BLP_DATA_NOT_AVAIALBLE = 100;
	private static final int BLP_DATA_SUCCESS = 100;
	
	private BlpDlwsProcessor() {		
	}
	
	public static BlpDlwsProcessor getInstance() {
		synchronized(lock) {
			if(processor == null) {
				processor = new BlpDlwsProcessor();
			}
		}
		return processor;
	}
	
	public boolean isSameInstrument(Instrument send,Instrument recieved) {
		boolean isSameInstrument = false;
		if(send != null && recieved != null) {
			if(!isEmptyStr(send.getId()) && !isEmptyStr(recieved.getId()) && send.getId().equals(recieved.getId())) {
				// overrides are not compared as not get it back from Blp
				isSameInstrument = true;
			}
		}
		return isSameInstrument;
	}	
	
	public BlpDlwsRequest processRequest(BlpDlwsRequest request) {
		SubmitGetDataRequest dataRequest = getDataRequest(request.getBbUserNumber());
		Integer errorCode = EXCEPTION_STATUS_ID;
		Integer responseStatusCode = -1;
		long startTime = System.currentTimeMillis(),endTime = -1;
		Set<String> instrumentSearchString = new LinkedHashSet<String>();
		Set<Integer> requestIds = new LinkedHashSet<Integer>();
		Instruments instruments = new Instruments();
		Fields fields = new Fields();
		Map<Integer,Instrument> requestInstruments = new HashMap<Integer,Instrument>();
		String responseId = "-1";
		try {
			initDataLicenseResult(request);
			collectInstrumentInfo(request,instruments,fields,instrumentSearchString,requestIds /*sessionRequests,*/, requestInstruments);
			if(instruments != null && fields != null && requestIds != null && !requestIds.isEmpty()) {
				dataRequest.setInstruments(instruments);
				dataRequest.setFields(fields);
				PerSecurityWS stub = SSLWrapper.getWrappedPerSecurityWSPort();
				SubmitGetDataResponse dataResponse = stub.submitGetDataRequest(dataRequest);
				String requestStatus = dataResponse.getStatusCode().getDescription();
				responseId = dataResponse.getResponseId();
				if(!isEmptyStr(responseId)) {
					request.getResult().setResponseId(responseId);
					RetrieveGetDataRequest retrieveDataRequest = new RetrieveGetDataRequest();
					retrieveDataRequest.setResponseId(responseId);
					RetrieveGetDataResponse retrieveDataResponse = new RetrieveGetDataResponse();
					log(new StringBuilder(responseId).append(" - ").append(requestStatus).append(" : ").append(requestIds).toString());
					int timeout = BLOOMBERG_THREAD_FORCED_TIMEOUT_MS;
					long endTimeMillis = System.currentTimeMillis() + timeout;
					do	{
				        if(System.currentTimeMillis() > endTimeMillis) {
				        	logger.log(Level.SEVERE,ERROR_TIMEOUT);
				        	throw new Exception("Forced Time Out : requests " + requestIds + " waiting more than "+ timeout +" ms");
				        }
				        try {
				        	// Blp Dlws takes time to get the results
				        	// Usually, take 50+ seconds.  Thus, no need to poll right away, and sleep for a period
				        	Thread.sleep(pollFrequency);
				        } catch (InterruptedException e) {
				        	StringBuilder errorInfo = new StringBuilder(LOG_PREFIX).append(ERROR_SYSTEM).append(" : ").append(requestIds);
							logger.log(Level.SEVERE,errorInfo.toString(),e);
				        }
				        retrieveDataResponse = stub.retrieveGetDataResponse(retrieveDataRequest);
				        pollFrequency = subsequentPollFrequency;
					} while (retrieveDataResponse.getStatusCode().getCode() == BLP_DATA_NOT_AVAIALBLE);
					responseStatusCode = retrieveDataResponse.getStatusCode().getCode();
					// Blp Dlws Results returned
					if(responseStatusCode == BLP_DATA_SUCCESS && retrieveDataResponse.getResponseId() != null && responseId.equals(retrieveDataResponse.getResponseId())) {
						endTime = System.currentTimeMillis();
						if(retrieveDataResponse.getInstrumentDatas() != null) {
						    List<InstrumentData> instrumentDatas = retrieveDataResponse.getInstrumentDatas().getInstrumentData();
							if(instrumentDatas != null && instrumentDatas.size() > 0) {
							    Iterator<InstrumentData> instrumentDataIterator = instrumentDatas.iterator();
								//verify if requested instruments length matches the returned ones.
								if(requestIds != null && requestIds.size() == instrumentDatas.size()) {
									Iterator<Integer> requestIterator = requestIds.iterator();
									while (instrumentDataIterator.hasNext()) {
										InstrumentData instrumentData = instrumentDataIterator.next();
										if(instrumentData != null) {
											String instrumentDataCode = (instrumentData.getCode() != null && !instrumentData.getCode().trim().equals("")) ? instrumentData.getCode().trim() : "-1";
											Integer requestId = requestIterator.next();
											Instrument instrumentSend = requestInstruments.get(requestId);
											Instrument instrumentRecieved = instrumentData.getInstrument();
											if(isSameInstrument(instrumentSend,instrumentRecieved)) {
												List<Data> data = instrumentData.getData();
												int instrumentCode = -1;
												try {
													instrumentCode = Integer.parseInt(instrumentDataCode);
												} catch(NumberFormatException e) {											
													logger.log(Level.SEVERE,"Error in parsing instrument data code " + instrumentDataCode + " for request " + requestId);
												}
												boolean isSuccessfulResponse = (instrumentCode == BLP_DATA_SUCCESS);
												Map<String,String> fieldValues = new HashMap<String,String>();
												for (int count = 0; count < data.size(); count++) {
													Data fieldData = data.get(count);
													String field = fields.getField().get(count);
													String value = "";
													if(isSuccessfulResponse) {
														value = fieldData.getValue();
													}
													value = value.trim().equals("") ? null : value;
													fieldValues.put(field, value);
												}
												populateRequestResult(request,requestId,instrumentCode,fieldValues,responseId);
											} else {
												StringBuilder errorInfo = new StringBuilder(" Request instrument id : ").append(instrumentSend.getId());
												errorInfo.append(" not matches Response instrument id : ").append(instrumentRecieved.getId());
												logger.log(Level.SEVERE,errorInfo.toString());
											}
										}
									}
								} else {
									StringBuilder errorInfo = new StringBuilder(" Request instrument size : ").append(requestInstruments.size());
									errorInfo.append(" not matches Response instrument size : ").append(instrumentDatas.size());
									logger.log(Level.SEVERE,errorInfo.toString());
								}								
							} else {
								endTime = System.currentTimeMillis();
								logEmptyIntrumentListResponse(request,requestIds,responseId);
							}
						} else {
							endTime = System.currentTimeMillis();
							logEmptyIntrumentListResponse(request,requestIds,responseId);
						}
					} else {
						endTime = System.currentTimeMillis();
						populateRequestResultWithError(request,requestIds,responseStatusCode,responseId);
						StringBuilder message = new StringBuilder("Error in submitted request : error code = ").append(responseStatusCode).append(", message = ");
						logger.log(Level.SEVERE,message.toString());
					}
				} else {
					StringBuilder errorInfo = new StringBuilder(LOG_PREFIX).append(" Invalid DLWS ResponseId ").append(" for requests: ").append(requestIds);
					logger.log(Level.SEVERE,errorInfo.toString());
					throw new Exception(" invalid responseid received from bloomberg ");
				}
			}
		}catch(java.rmi.RemoteException t) {
			responseId = String.valueOf(HTTP_CONNECTION_FAIL);
			errorCode = HTTP_CONNECTION_FAIL;
			logger.log(Level.SEVERE,LOG_PREFIX,t);
			populateRequestResultWithError(request,requestIds,errorCode,responseId);			
		}catch(Throwable t) {
			logger.log(Level.SEVERE,LOG_PREFIX,t);
			populateRequestResultWithError(request,requestIds,errorCode,responseId);
		} finally {
			request.getResult().setResponseStatusCode(responseStatusCode);
			StringBuilder responseTime = new StringBuilder("PERF:").append(requestIds).append(":");
			if(endTime == -1) {
				responseTime.append(endTime);
				log(new StringBuilder("NO END TIME - ").append(" request not submitted or request failed with exception? ").toString());
			} else {
				responseTime.append((endTime - startTime)/1000).append(" sec");
			}
			log(responseTime.toString());
			// ***********************************************************
			// Process the results in the request object
			// doSomething(request);
		}
		return request;
	}
	
	private void logEmptyIntrumentListResponse(BlpDlwsRequest request,Set<Integer> requestIds,String responseId) {
		String error = "ERROR";
		populateRequestResultWithError(request,requestIds,EXCEPTION_STATUS_ID,responseId);
		StringBuilder message = new StringBuilder("Successful response but no instrument list in the returned response").append(", message = ").append(error);
		logger.log(Level.SEVERE,message.toString());
	}
	
	private void initDataLicenseResult(BlpDlwsRequest request) {
		if(request != null) {
			BlpDlwsResult result = request.getResult();
			if(result == null) {
				result = new BlpDlwsResult();
				result.setRequestResultMap(new HashMap<Integer, Map<String,String>>());
				result.setRequestStatusMap(new HashMap<Integer,Integer>());
				request.setResult(result);
			} else {
				if(result.getRequestResultMap() == null) {
					result.setRequestResultMap(new HashMap<Integer, Map<String,String>>());
				}
				if(result.getRequestStatusMap() == null) {
					result.setRequestStatusMap(new HashMap<Integer,Integer>());
				}
			}
		}
	}
	
	private void populateRequestResult(BlpDlwsRequest request,Integer requestId,Integer statusCode,Map<String,String> fieldValues,String responseId) {
		if(request != null && requestId != null && responseId != null) {
			request.getResult().getRequestResultMap().put(requestId, fieldValues);
			request.getResult().getRequestStatusMap().put(requestId, statusCode);
			request.getResult().setResponseId(responseId);
		}
	}
	
	private void populateRequestResultWithError(BlpDlwsRequest request,Set<Integer> requestIds,Integer errorCode,String responseId) {
		if(request != null && requestIds != null && !requestIds.isEmpty() && responseId != null) {
			for(Integer requestid : requestIds) {
				request.getResult().getRequestResultMap().put(requestid,Collections.<String,String>emptyMap());
				request.getResult().getRequestStatusMap().put(requestid,errorCode);
				request.getResult().setResponseId(responseId);
			}
		}
	}
	
	private void collectInstrumentInfo(BlpDlwsRequest request,Instruments instruments,Fields fields,Set<String> instrumentSearchString,Set<Integer> requestIds/*,Map<Integer,Set<Integer>> sessionRequests*/,Map<Integer,Instrument> requestInstruments) throws Exception {
		if(request != null && request.getSearchList() != null && !request.getSearchList().isEmpty()) {
			StringBuilder requestInfo = new StringBuilder();
			Instrument[] instrumentArray = new Instrument[request.getSearchList().size()];
			List<BlpDlwsInstruments> searchList = request.getSearchList();
			for(int count = 0 ; count < searchList.size(); count++) {
				BlpDlwsInstruments search = searchList.get(count);
				if(search != null) {
					if(count != 0) {
						requestInfo.append(" , ");
					}
					Integer requestId = search.getRequestId();
					Instrument instrument = search.getInstrument();
					if(instrument != null && instrument.getId() != null /* && sessionId != null */ && requestId != null) {
						requestInfo.append(search.toString());
						instrumentSearchString.add(search.getSearchString());
						instrumentArray[count] = instrument;
						requestIds.add(search.getRequestId());
						requestInstruments.put(search.getRequestId(), instrument);
					} else {
						StringBuilder missingInfo = new StringBuilder(" missing datalicense request information : ");
						missingInfo.append("requestid:").append((requestId == null ? "" : requestId)).append(",");
						missingInfo.append("instrumentid:").append(((instrument == null || instrument.getId() == null) ? "" : instrument.getId()));
						logger.log(Level.SEVERE,missingInfo.toString());
					}
				} 
			}
			log(requestInfo.toString());
			instruments.getInstrument().addAll(Arrays.asList(instrumentArray));
			collectFields(request,fields,requestIds);
		} else {
			throw new Exception("no instruments present in datalicense request");
		}		
	}
	
	private void collectFields(BlpDlwsRequest request,Fields fields,Set<Integer> requestIds) throws Exception {
		Set<String> bbfields = request.getBbFields();
		if(bbfields != null && !bbfields.isEmpty()) {
			String[] allfields = new String[bbfields.size()];
			allfields = bbfields.toArray(allfields);
			fields.getField().addAll(Arrays.asList(allfields));
		} else {
			throw new Exception("no Mnemonics present in datalicense request : " + requestIds);
		}
	}
	
	private void log(String message) {
		logger.info(new StringBuilder("BLPDLWS").append(message).toString());
	}
		
	private SubmitGetDataRequest getDataRequest(Integer bloombergUserNumber) {
		SubmitGetDataRequest dataRequest = new SubmitGetDataRequest();
		GetDataHeaders dataHeaders = new GetDataHeaders();
		dataHeaders.setClosingvalues(Boolean.TRUE);
		dataHeaders.setSecmaster(Boolean.TRUE);
		dataHeaders.setDerived(Boolean.TRUE);
		dataHeaders.setQuotecomposite(Boolean.TRUE);
		dataHeaders.setHistorical(Boolean.FALSE);
		dataHeaders.setUsernumber(bloombergUserNumber);
		dataRequest.setHeaders(dataHeaders);
		return dataRequest;
	}
	
	public final static boolean isEmptyStr(String str) {
		if (str != null && str.trim().length()>0) {
			return false;
		}
		return true;
	}	
	
}
