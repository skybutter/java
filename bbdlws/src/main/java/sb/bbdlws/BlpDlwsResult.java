package sb.bbdlws;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("serial")
public class BlpDlwsResult implements Serializable{
	
	private String responseId;
	private Integer responseStatusCode;
	private Map<Integer,Map<String,String>>  requestResultMap = null;
	private Map<Integer,Integer> requestStatusMap = null;
	
	public Map<Integer, Map<String,String>> getRequestResultMap() {
		return requestResultMap;
	}
	
	public void setRequestResultMap(Map<Integer, Map<String,String>> requestResultMap) {
		this.requestResultMap = requestResultMap;
	}
	
	public Map<Integer, Integer> getRequestStatusMap() {
		return requestStatusMap;
	}
	
	public void setRequestStatusMap(Map<Integer, Integer> requestStatusMap) {
		this.requestStatusMap = requestStatusMap;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	
	public Integer getResponseStatusCode() {
		return responseStatusCode;
	}
	
	public void setResponseStatusCode(Integer responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}

}
