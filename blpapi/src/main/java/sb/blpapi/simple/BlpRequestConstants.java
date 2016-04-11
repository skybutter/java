package sb.blpapi.simple;

public interface BlpRequestConstants {

	String CHK_BLP_SECURITY_STR = "ORCL2 US Equity";
	String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	String DATE_FORMAT_US = "MM/dd/yyyy";

	String BLP_ERR_PREFIX = "BlpError - ";
	String BLP_ERR_UNLICENSED = "#N/A Auth";
	String BLP_ERR_BADSECURITY = "#N/A Security";

	int MAX_OVERRIDES = 100;
	// http://www.bloomberglabs.com/api/content/uploads/sites/2/2014/07/blpapi-developers-guide-2.54.pdf
	
    // defines the bloomberg reference data service operations
	// Doc Section A.2.1 Operations - Request Type
    final String REQUEST_TYPE_HISTORICAL_DATA = "HistoricalDataRequest";
    final String REQUEST_TYPE_INTRA_DAY_TICK = "IntraDayTickRequest";
    final String REQUEST_TYPE_INTRA_DAY_BAR = "IntraDayBarRequest";
    final String REQUEST_TYPE_REFERENCE_DATA = "ReferenceDataRequest";
    final String REQUEST_TYPE_PORTFOLIO_DATA = "PortfolioDataRequest";
    final String REQUEST_TYPE_BEQS = "BeqsRequest";

    // Doc Section A.2.2 ReferenceDataRequest: Sequence
    final String SECURITIES = "securities";
    final String FIELDS = "fields";
    final String OVERRIDES = "overrides";
    final String OVERRIDE_FIELD_ID = "fieldId";
    final String OVERRIDE_VALUE = "value";
    final String RETURN_EIDS = "returnEids";
    final String RETURN_FORMATTED_VALUE = "returnFormattedValue";
    final String USE_UTC_TIME = "useUTCTime";
    final String FORCED_DELAY = "forcedDelay";
    
    // Doc Section A.2.4 HistoricalDataRequest: Sequence
    final String START_DATE = "startDate";
    final String END_DATE = "endDate";
    final String HISTORICAL_DATE = "date";
    final String HISTORICAL_DATE_SINCE = "01/01/1900";

    // Doc Section A.2.14 Reference Data Service Response
    final String RESPONSE_ERROR = "responseError";
    final String SECURITY_DATA = "securityData";
    final String SECURITY = "security";
    final String SEQUENCE_NUMBER = "sequenceNumber";
    final String FIELD_DATA = "fieldData";
    final String SECURITY_ERROR = "securityError";
    final String FIELD_EXCEPTIONS = "fieldExceptions";
    final String FIELD_ID = "fieldId";
    final String ERROR_INFO = "errorInfo";
    final String CATEGORY = "category";
    final String MESSAGE = "message";
    
    // Doc Section B.1 General
    final String SESSION_STARTED = "SessionStarted";
    final String SESSION_TERMINATED = "SessionTerminated";
    final String SESSION_STARTUP_FAILURE = "SessionStartupFailure";
    final String SESSION_CONNECTION_UP = "SessionConnectionUp";
    final String SESSION_CONNECTION_DOWN = "SessionConnectionDown";
    final String SERVICE_OPENED = "ServiceOpened";
    final String SERVICE_OPEN_FAILURE = "ServiceOpenFailure";    
}
