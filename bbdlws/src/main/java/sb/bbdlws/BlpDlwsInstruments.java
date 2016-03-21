package sb.bbdlws;

import java.io.Serializable;

import com.bloomberg.datalic.dlps.Instrument;
import com.bloomberg.datalic.dlps.Override;

@SuppressWarnings("serial")
public class BlpDlwsInstruments implements Serializable{
	private Instrument instrument = null;
	// requestId is not required for Dlws 
	// it is for managing Dlws requests in the caller
	private Integer requestId = null;
	
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getSearchString() {
        return instrument != null ? (instrument.getId() +" "+ instrument.getYellowkey()):" ";
    }
		
	public String toString() {
		StringBuilder searchInfo = new StringBuilder();
		searchInfo.append("[");
		searchInfo.append((getRequestId() != null ? getRequestId() : ""));
		searchInfo.append(",");
		if(getInstrument() != null) {
			searchInfo.append(",");
			searchInfo.append((getInstrument().getId() != null ? getInstrument().getId() : ""));
			if(getInstrument().getOverrides() != null && getInstrument().getOverrides().getOverride() != null && getInstrument().getOverrides().getOverride().size() > 0) {
				Override[] overrides = (Override[]) getInstrument().getOverrides().getOverride().toArray(new Override[0]);
				searchInfo.append(",");
				searchInfo.append("{");
				StringBuilder overrideInfo = new StringBuilder();
				for(int count = 0; count < overrides.length; count++) {
					Override override = overrides[count];
					if(count != 0) {
                        overrideInfo.append(",");
                    }
					overrideInfo.append(override.getField()).append(" = ").append(override.getValue());
				}
				searchInfo.append(overrideInfo.toString());
				searchInfo.append("}");				
			}			
		}
		searchInfo.append("]");
		return searchInfo.toString();
	}
}
