package sb.bbdlws;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class BlpDlwsRequest implements Serializable{
	private List<BlpDlwsInstruments>  searchList = null; 
	private Set<String> bbFields = null; 
	private BlpDlwsResult result = null;
	private Integer bbUserNumber = null;
	public Set<String> getBbFields() {
		return bbFields;
	}
	public void setBbFields(Set<String> bbFields) {
		this.bbFields = bbFields;
	}
	public BlpDlwsResult getResult() {
		return result;
	}
	public void setResult(BlpDlwsResult result) {
		this.result = result;
	}
	public List<BlpDlwsInstruments> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<BlpDlwsInstruments> searchList) {
		this.searchList = searchList;
	}
	public Integer getBbUserNumber() {
		return bbUserNumber;
	}
	public void setBbUserNumber(Integer bbUserNumber) {
		this.bbUserNumber = bbUserNumber;
	}
}
