package sb.blpapi.simple;

public enum BlpYellowKey {
	// List came from https://en.wikipedia.org/wiki/Bloomberg_Terminal
    GOVT(2, "Govt"),
    CORP(3, "Corp"),
    MTGE(4, "Mtge"),
    MMKT(5, "M-Mkt"),
    MUNI(6, "Muni"),
    PFD(7, "Pfd"),
    EQUITY(8, "Equity"),
    COMDTY(9, "Comdty"),
    INDEX(10, "Index"),
    CURNCY(11, "Curncy"),
    CLIENT(12, "Client");
	
	private int yellowKeyId;
	private String stringValue;
	
	private BlpYellowKey(int id, String stringValue) {
		this.yellowKeyId = id;
		this.stringValue = stringValue;
	}
	
	public BlpYellowKey getBlpYellowKey(int id) {
		switch (id) {
		case 2: return GOVT;
		case 3: return CORP;
		case 4: return MTGE;
		case 5: return MMKT;
		case 6: return MUNI;
		case 7: return PFD;
		case 8: return EQUITY;
		case 9: return COMDTY;
		case 10: return INDEX;
		case 11: return CURNCY;
		case 12: return CLIENT;
		}
		throw new IllegalArgumentException("Not a valid Bloomberg Yellow Key: "+id);
	}
	
	public String toString(){
		return stringValue;
	}
}
