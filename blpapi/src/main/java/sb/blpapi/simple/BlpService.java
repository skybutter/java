package sb.blpapi.simple;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bloomberglp.blpapi.CorrelationID;
import com.bloomberglp.blpapi.DuplicateCorrelationIDException;
import com.bloomberglp.blpapi.Element;
import com.bloomberglp.blpapi.ElementIterator;
import com.bloomberglp.blpapi.Event;
import com.bloomberglp.blpapi.InvalidConversionException;
import com.bloomberglp.blpapi.InvalidRequestException;
import com.bloomberglp.blpapi.Message;
import com.bloomberglp.blpapi.MessageIterator;
import com.bloomberglp.blpapi.NotFoundException;
import com.bloomberglp.blpapi.Request;
import com.bloomberglp.blpapi.RequestQueueOverflowException;
import com.bloomberglp.blpapi.Schema;
import com.bloomberglp.blpapi.Service;
import com.bloomberglp.blpapi.Session;
import com.bloomberglp.blpapi.SessionOptions;

public class BlpService {
	
    private final static Logger logger = Logger.getLogger(BlpService.class.getName());
    private static BlpService instance = null;
    
    // Bloomberg Desktop API host and port
    private String serverHost = "localhost";
    private int serverPort = 8194;
    private String blpService = "//blp/refdata";

    private SessionOptions sessionOptions;
    private Session session;

    private BlpService() {
        init();
    }
    
    public static BlpService getInstance() {
    	synchronized(BlpService.class) {
    		if (instance==null) {
    			instance = new BlpService();
    		}
    	}
    	return instance;
    }

    private void init() {    	
        sessionOptions = new SessionOptions();
        sessionOptions.setServerHost(serverHost);
        sessionOptions.setServerPort(serverPort);
        try {
            start();
            logger.log(Level.INFO, "BlpService started.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unable to start BlpService!", e);
        }
    }
    
    protected void start() throws IOException, InterruptedException {
        logger.log(Level.INFO, "Starting Bloomberg session options - " + serverHost + ":" + serverPort);
        session = new Session(sessionOptions);
        if (!session.start()) {
            String msg = "Unable to start Blp session.";
            logger.log(Level.SEVERE, msg, new BlpApiException(msg));
            return;
        }
        if (!session.openService(blpService)) {
            String msg = "Unable to open service to Blp " + blpService;
            logger.log(Level.SEVERE, msg, new BlpApiException(msg));
            return;
        }
    }

    protected void stop() throws InterruptedException {
        if (session != null) {
            logger.log(Level.INFO, "Stopping Bloomberg session.");
            session.stop();
            logger.log(Level.INFO, "Bloomberg session stopped.");
        } else {
        	logger.log(Level.INFO, "No Bloomberg session, no need to stop.");
        }
    }

    public void cleanup() {
    	try {    		
            stop();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unable to stop BlpService!", e);
        } finally {
            logger.log(Level.INFO, "BlpService - Done.");
    	}
    }

    private boolean isRequestMatch(CorrelationID requestId, Event event) {
        boolean matched = false;
        if (requestId != null && event != null) {
            MessageIterator messageIterator = event.messageIterator();
            while (messageIterator.hasNext()) {
                Message msg = messageIterator.next();
                if (msg.correlationID() == requestId) {
                	matched = true;
                }
            }
        }
        return matched;
    }

    public BlpResult sendRequest(BlpRequest req) throws BlpApiException {
    	
    	List<String> securities = req.getSearchStrings();
        if (securities.isEmpty())
        	return null;
        
        List<String> fields = req.getFields();
        Map<String, String> overrides = req.getOverrideFields();
        
        // http://www.bloomberglabs.com/api/content/uploads/sites/2/2014/07/blpapi-developers-guide-2.54.pdf
        // Doc 7.1.4 Overrides.  Maximum of 100 overrides in a single request
        if (overrides.size() > BlpRequestConstants.MAX_OVERRIDES) {
            StringBuffer errorMessage = new StringBuffer("Number of overrides specified ").append(overrides.size()).append(" exceed the maximum " + BlpRequestConstants.MAX_OVERRIDES);
            logger.log(Level.SEVERE, errorMessage.toString());
            throw new BlpApiException(errorMessage.toString());
        }
        // http://www.bloomberglabs.com/api/content/uploads/sites/2/2014/07/blpapi-developers-guide-2.54.pdf
        // Section 2.1
        // To assist applications in matching incoming data to requests, 
        // the Bloomberg API allows applications to provide a CorrelationID object with each request.
        // Subsequently, the Bloomberg infrastructure uses that identifier to tag the events sent in response. 
        // On receipt of the Event object, the client can use the identifier it supplied to match events to requests.
        CorrelationID requestId = null;
        Service service = session.getService(blpService);
        if (service!=null) {
            Request request = null;
            if (req.isHistoricalRequest()) {
                request = service.createRequest(BlpRequestConstants.REQUEST_TYPE_HISTORICAL_DATA);
                if (req.getHistoricalDate() != null) {
                    DateFormat df = new SimpleDateFormat(BlpRequestConstants.DATE_FORMAT_YYYYMMDD);
                    String historicalDate = df.format(req.getHistoricalDate());
                    logger.log(Level.FINEST, "Historical Date : " + historicalDate);
                    request.set(BlpRequestConstants.START_DATE, historicalDate);
                    request.set(BlpRequestConstants.END_DATE, historicalDate);
                    //request.set("periodicitySelection", "DAILY");
                }
            } else {
                request = service.createRequest(BlpRequestConstants.REQUEST_TYPE_REFERENCE_DATA);
            }
            if (request!=null) {
            	
            	Map<String, Map<String, Object>> blpResult = new HashMap<String, Map<String, Object>>();
            	
                boolean waitingForBlp = true;
                boolean isBloombergTimedOut = false;
                try {
                    for (String securityString: securities) {
                        request.getElement(BlpRequestConstants.SECURITIES).appendValue(securityString);
                    }
                    for (String field: fields) {
                        request.getElement(BlpRequestConstants.FIELDS).appendValue(field);
                    }
                    if (overrides.size() > 0) {
                        Element overrideElement = request.getElement(BlpRequestConstants.OVERRIDES);
                        for (String overrideField: overrides.keySet()) {
                            Element override = overrideElement.appendElement();
                            override.setElement(BlpRequestConstants.OVERRIDE_FIELD_ID, overrideField);
                            override.setElement(BlpRequestConstants.OVERRIDE_VALUE, overrides.get(overrideField));
                        }
                    }
                    logger.log(Level.INFO, " Sending Blp Request " + request.asElement().name().toString());
                    requestId = session.sendRequest(request, null);
                    while (waitingForBlp) {
                        Event event = session.nextEvent();
                        if (isRequestMatch(requestId, event)) {
                        	Map<String, Map<String, Object>> partialResult = null;
                            switch (event.eventType().intValue()) {
                                case Event.EventType.Constants.RESPONSE:
                                    waitingForBlp = false;
                                    partialResult = processResponse(event, req);
                                    blpResult.putAll(partialResult);
                                    break;
                                case Event.EventType.Constants.PARTIAL_RESPONSE:
                                	// For historical request with multiple securities, each security return as partial response
                                	partialResult = processResponse(event, req);
                                	blpResult.putAll(partialResult);
                                    break;
                                case Event.EventType.Constants.TIMEOUT:
                                    waitingForBlp = false;
                                    isBloombergTimedOut = true;
                                    processTimeout(event, securities, fields);
                                    break;
                                default:
                                    waitingForBlp = false;
                                    isBloombergTimedOut = true;
                                    processOther(event, securities, fields);
                                    break;
                            }
                        }
                    }
                } catch (NotFoundException e) {
                    logger.log(Level.SEVERE, "NotFoundException :", e);
                    throw new BlpApiException(e.description());
                } catch (InvalidConversionException e) {
                    logger.log(Level.SEVERE, "InvalidConversionException :", e);
                    throw new BlpApiException(e.description());
                } catch (InvalidRequestException e) {
                    logger.log(Level.SEVERE, "InvalidRequestException :", e);
                    throw new BlpApiException(e.description());
                } catch (RequestQueueOverflowException e) {
                    logger.log(Level.SEVERE, "RequestQueueOverflowException :", e);
                    throw new BlpApiException(e.description());
                } catch (DuplicateCorrelationIDException e) {
                    logger.log(Level.SEVERE, "DuplicateCorrelationIDException :", e);
                    throw new BlpApiException(e.description());
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "IOException :", e);
                    throw new BlpApiException(e.getMessage());
                } catch (BlpApiException e) {
                    logger.log(Level.SEVERE, "BlpApiException :", e);
                    throw e;
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Exception :", e);
                    throw new BlpApiException(e.getMessage());
                }
                if (!waitingForBlp && !isBloombergTimedOut) {
               		return new BlpResult(req, blpResult);
                }
            } else {
            	logger.log(Level.SEVERE, "Request is null.  No request is made.");
            }
        } else {
        	logger.log(Level.SEVERE, "Service is null.  No request is made.");
        }
        return null;
    }

    private boolean processResponseError(Event event, BlpRequest request, Map<String, Map<String, Object>> blpResponse) throws BlpApiException {
    	// Not sure if this method for handling error work or not
        boolean hasResponseError = false;
        if (event != null) {
        	String msg = "";
            StringBuilder errMsg = new StringBuilder();
            MessageIterator it = event.messageIterator();
            while (it.hasNext()) {
                Message message = it.next();
                Element response = message.asElement();
                if (response.hasElement(BlpRequestConstants.RESPONSE_ERROR)) {
                    logger.log(Level.SEVERE, "Blp response errored " + message.toString());
                    hasResponseError = true;
                    Element responseError = message.getElement(BlpRequestConstants.RESPONSE_ERROR);
                    if (!errMsg.toString().trim().equals("")) {
                        errMsg.append("\n");
                    }
                    msg = BlpRequestConstants.BLP_ERR_PREFIX + responseError.getElementAsString(BlpRequestConstants.MESSAGE);
                    errMsg.append(msg);
                }
            }
            if (hasResponseError) {
                logger.log(Level.SEVERE, errMsg.toString());
                String[] securities = request.getSecurityStrings();
                for (int i=0; i < securities.length; i++) {
                	Map<String, Object> fieldValues = new HashMap<String, Object>();
                    for (String field : request.getFields()) {
                        fieldValues.put(field, msg);
                    }                	
                	blpResponse.put(securities[i], fieldValues);
                }
            }
        }
        return hasResponseError;
    }

    private String processSecurityException(Element security) {
    	String errMsg = null;
        if (security.hasElement(BlpRequestConstants.SECURITY_ERROR)) {
            Element securityError = security.getElement(BlpRequestConstants.SECURITY_ERROR);
            errMsg = BlpRequestConstants.BLP_ERR_PREFIX + securityError.getElementAsString(BlpRequestConstants.MESSAGE);
        }
        return errMsg;
    }
    
    private Map<String, String> processFieldException(Element security) {
    	
        Map<String, String> fieldExceptionMsg = new HashMap<String, String>();
        if (security.hasElement(BlpRequestConstants.FIELD_EXCEPTIONS)) {
            Element fieldExceptions = security.getElement(BlpRequestConstants.FIELD_EXCEPTIONS);
            if (fieldExceptions.numValues() > 0) {
                String securityName = security.getElementAsString(BlpRequestConstants.SECURITY);
                StringBuilder errorLog = new StringBuilder();
                for (int i = 0; i < fieldExceptions.numValues(); i++) {
                    Element fieldException = fieldExceptions.getValueAsElement(i);
                    String fieldId = fieldException.getElementAsString(BlpRequestConstants.FIELD_ID);
                    String msg = fieldException.getElement(BlpRequestConstants.ERROR_INFO).getElementAsString(BlpRequestConstants.MESSAGE);
                    fieldExceptionMsg.put(fieldId, BlpRequestConstants.BLP_ERR_PREFIX + msg);
                    if (!errorLog.toString().trim().equals("")) {
                        errorLog.append("\n");
                    }
                    errorLog.append(fieldException.getElement(BlpRequestConstants.ERROR_INFO).getElementAsString(BlpRequestConstants.CATEGORY));
                    errorLog.append(securityName + " : " + fieldException.getElementAsString(BlpRequestConstants.FIELD_ID));
                }
                logger.log(Level.INFO, errorLog.toString());
            }
        }
        return fieldExceptionMsg;
    }

    private String getDateAsString (Calendar calendar) {
        return (new SimpleDateFormat(BlpRequestConstants.DATE_FORMAT_US).format(calendar.getTime())).toString();
    }

    private Object getValue (Element field) throws InvalidConversionException {
        Object value = null;
        switch (field.datatype().intValue()) {
            case Schema.Datatype.Constants.BOOL:
                return field.getValueAsBool();
            case Schema.Datatype.Constants.CHAR:
                return field.getValueAsString();
            case Schema.Datatype.Constants.DATE:
                return getDateAsString(field.getValueAsDate().calendar());
            case Schema.Datatype.Constants.DATETIME:
                return getDateAsString(field.getValueAsDatetime().calendar());
            case Schema.Datatype.Constants.FLOAT32:
                return field.getValueAsFloat64();
            case Schema.Datatype.Constants.FLOAT64:
                return field.getValueAsFloat64();
            case Schema.Datatype.Constants.INT32:
                return field.getValueAsFloat64();
            case Schema.Datatype.Constants.INT64:
                return field.getValueAsFloat64();
            case Schema.Datatype.Constants.STRING:
                return field.getValueAsString();
            case Schema.Datatype.Constants.TIME:
                return getDateAsString(field.getValueAsDatetime().calendar());
            case Schema.Datatype.Constants.SEQUENCE:
            case Schema.Datatype.Constants.CHOICE:
            case Schema.Datatype.Constants.ENUMERATION:
            case Schema.Datatype.Constants.BYTEARRAY:
                return field.getValueAsString(); // need to check ???
        }
        return value;
    }

    private Map<String, Object> processResponse(Element security, BlpRequest request) {
    	
    	Map<String, Object> securityResult = new HashMap<String, Object>();
        List<String> fields = request.getFields();        
        Map<String, String> fieldErrors = processFieldException(security);
        if (!fieldErrors.isEmpty()) {
        	securityResult.putAll(fieldErrors);
        }
        String securityExceptionMsg = processSecurityException(security);
        if (securityExceptionMsg != null && !securityExceptionMsg.isEmpty()) {
            for (int i = 0; i < fields.size(); i++) {
                securityResult.put(fields.get(i), securityExceptionMsg);
            }
        } else {
            Element fieldDataArray = security.getElement(BlpRequestConstants.FIELD_DATA);
            if (request.isHistoricalRequest()) {
                    for (int i = 0; i < fieldDataArray.numValues(); i++) {
                        Element fieldData = fieldDataArray.getValueAsElement(i);
                        for (int j = 0; j < fieldData.numElements(); j++) {
                            Element field = fieldData.getElement(j);
                            Object fieldValue = null;
                            if (field.numValues() > 0) {
                                try {
                                    fieldValue = getValue(field);
                                } catch (InvalidConversionException e) {
                                    logger.log(Level.INFO, "Unable to get field value for " + field.name().toString() + ".  " + e.getMessage());
                                }
                            }
                            securityResult.put(field.name().toString(), fieldValue);
                        }
                    }
            } else {
                ElementIterator it = fieldDataArray.elementIterator();
                while (it.hasNext()) {
                    Element field = it.next();
                    Object fieldValue = null;
                    if (field.numValues() > 0) {
                        try {
                            fieldValue = getValue(field);
                        } catch (InvalidConversionException e) {
                            logger.log(Level.INFO, "Unable to get field value for " + field.name().toString() + ".  " + e.getMessage());
                        }
                    }
                    securityResult.put(field.name().toString(), fieldValue);
                }
            }
        }
        return securityResult;
    }

    private Map<String, Map<String, Object>> processResponse(Event event, BlpRequest request) throws BlpApiException {
    	
    	Map<String, Map<String, Object>> blpResponse = new HashMap<String, Map<String, Object>>();
        logger.log(Level.INFO, "Processing Blp Response " + (event.eventType() == Event.EventType.PARTIAL_RESPONSE ? "Partial" : ""));
        if (event != null && !processResponseError(event, request, blpResponse)) {
            MessageIterator it = event.messageIterator();
            while (it.hasNext()) {
                Message message = it.next();
                Element response = message.asElement();
                if (response.hasElement(BlpRequestConstants.SECURITY_DATA)) {
                    Element securityData = response.getElement(BlpRequestConstants.SECURITY_DATA);
                    if (request.isHistoricalRequest()) {
                        String securitySearchStr = securityData.getElementAsString(BlpRequestConstants.SECURITY);
                        Map<String, Object> responseFields = processResponse(securityData, request);
                        blpResponse.put(securitySearchStr, responseFields);
                    } else {
                        if (securityData.numValues() > 0) {
                            for (int i = 0; i < securityData.numValues(); i++) {
                                Element security = securityData.getValueAsElement(i);
                                String securitySearchStr = security.getElementAsString(BlpRequestConstants.SECURITY);
                                Map<String, Object> responseFields = processResponse(security, request); 
                                blpResponse.put(securitySearchStr, responseFields);
                            }
                        }
                    }
                }
            }
        }
        return blpResponse;
    }

    private void processTimeout(Event event, List<String> securities, List<String> fields) throws BlpApiException {
        logger.log(Level.INFO, "Blp request timeout! " + "Event=" + event.eventType().toString() + ", Securities=" + securities + ", Fields=" + fields);
    }

    private void processOther(Event event, List<String> securities, List<String> fields) throws BlpApiException {
        logger.log(Level.INFO, "handling other bloomberg event! " + "Event=" + event.eventType().toString() + ", Securities=" + securities + ", Fields=" + fields);
        MessageIterator it = event.messageIterator();
        while (it.hasNext()) {
            Message message = it.next();
            logger.log(Level.INFO, message.messageType().toString());
        }
    }

    private boolean isSessionStartedEvent(Event event) {
        boolean isSessionStarted = false;
        if (event.eventType() == Event.EventType.SESSION_STATUS) {
            MessageIterator iter = event.messageIterator();
            while (iter.hasNext()) {
                Message message = iter.next();
                if (message.messageType().equals("SessionStarted")) {
                    isSessionStarted = true;
                    logger.log(Level.INFO, "session started event");
                }

            }
        }
        return isSessionStarted;
    }

    private boolean isServiceOpenedEvent(Event event) {
        boolean isServiceOpened = false;
        if (event.eventType() == Event.EventType.SERVICE_STATUS) {
            MessageIterator iter = event.messageIterator();
            while (iter.hasNext()) {
                Message message = iter.next();
                if (message.messageType().equals(BlpRequestConstants.SERVICE_OPENED)) {
                    isServiceOpened = true;
                    logger.log(Level.INFO, "service opened event");
                }
            }
        }
        return isServiceOpened;
    }

    protected void restartSession() {
        synchronized (BlpService.class) {
            logger.info("======== restarting Blp Session BEGIN =========");
            try {
                stop();
                start();
            } catch (IOException | InterruptedException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception occurred.", e);
            }
            logger.info("========= restarting Blp Session END ===================");
        }
    }
}