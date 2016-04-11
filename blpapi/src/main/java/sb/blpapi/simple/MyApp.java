package sb.blpapi.simple;

import java.util.Date;
import java.util.logging.Logger;

public class MyApp {

	private final static Logger logger = Logger.getLogger(MyApp.class.getName());
	private final static boolean historical = true;
	
	public static void main(String[] args) {
		applicationStart();
	}
	
	public static void applicationStart() {		
		BlpServiceWrapper bb = BlpServiceWrapper.getInstance(true);
		try {
			boolean ready = bb.isReadyToRun();
			if (ready) {
				BlpRequest query = null;
				BlpResult result = null;
				if (historical) {
					query = getHistoricalRequest();
				} else {
					query = getAccruedInterestOnSettleDtQuery(new Date());
				}
				result = bb.sendRequest(query);
				logger.info("BlpRequest=" + query);
				logger.info("BBResult=" + result);
			}
		} catch (BlpApiException e) {
			logger.severe("Error calling executeQuery()");
		}
	}

    public static BlpRequest getAccruedInterestOnSettleDtQuery(Date settleDate){
        BlpRequest accIntQuery = new BlpRequest();
        accIntQuery.addField(BlpMnemonics.INT_ACC);
        accIntQuery.addField(BlpMnemonics.FACTOR);
        accIntQuery.addField(BlpMnemonics.SETTLE_DT);
        accIntQuery.addField(BlpMnemonics.PRICING_SOURCE);
        Date newDate = new Date();
        newDate.setTime(settleDate.getTime());
        accIntQuery.addOverrideField(BlpMnemonics.SETTLE_DT, newDate);
        BlpSecurity security = createBBSecuritySearch("912828VV9", BlpYellowKey.GOVT.toString());        
        accIntQuery.addSecurity(security);
        accIntQuery.addSecurity(createSecuritySearch("MSFT US Equity"));
        accIntQuery.addSecurity(createSecuritySearch("AZ1 US Equity"));
        return accIntQuery;
    }
    
    public static BlpSecurity createBBSecuritySearch(String cusip, String yellowKey) {
    	BlpSecurity bbSecurity = new BlpSecurity();
    	bbSecurity.setCusip(cusip);
    	bbSecurity.setYellowKey(yellowKey);
    	return bbSecurity;
    }
    public static BlpSecurity createSecuritySearch(String searchString) {
    	BlpSecurity bbSecurity = new BlpSecurity();
    	bbSecurity.setSecuritySearch(searchString);
    	return bbSecurity;
    }
    
    public static BlpRequest getHistoricalRequest() {
    	BlpRequest query = new BlpRequest();
    	query.addField(BlpMnemonics.PX_LAST);
    	query.addField(BlpMnemonics.INT_ACC);
    	query.addField(BlpMnemonics.OPEN);
    	query.setHistoricalRequest(true);
    	query.setHistoricalDate(new Date(116, 2, 28));		// 2016-03-28
        query.addSecurity(createSecuritySearch("IBM US Equity"));
        query.addSecurity(createSecuritySearch("MSFT US Equity"));
        query.addSecurity(createSecuritySearch("AZ1 US Equity"));
    	return query;
    }
}
