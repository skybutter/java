package sb.blpapi.simple;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BlpServiceWrapper {
    private final static Logger logger = Logger.getLogger(BlpServiceWrapper.class.getName());

    private static BlpServiceWrapper instance = null;
    private static BlpService blpService = null;
    private static boolean blpEnabled = true;
    private static boolean blpServiceStarted = false;

    private BlpServiceWrapper(boolean b) {    	
        setBloombergEnabled(b);
        init();
    }

    public static BlpServiceWrapper getInstance(boolean b) {
    	synchronized (BlpServiceWrapper.class) {
            setBloombergEnabled(b);
            if (instance == null) {
                instance = new BlpServiceWrapper(b);
            }
            logger.log(Level.INFO, "Creating BlpTool instance for Bloomberg connection");
    	}
        return instance;
    }

    private void init() {
        blpService = BlpService.getInstance();
        blpServiceStarted = true;
    }

    public void cleanup() {
        if (blpService != null) {
            blpService.cleanup();
        }
    }
    
    public boolean isReadyToRun() throws BlpApiException {
        if (!blpServiceStarted) {
            init();
        }
        return checkBloombergCall();
    }

    private static boolean checkBloombergCall() throws BlpApiException {
        if (instance == null) {
            logger.log(Level.SEVERE, "Not started!");
            throw new BlpApiException("Not started!");
        }
        logger.log(Level.INFO, "Checking Blp API service...");
        if (blpEnabled) {
            BlpRequest tstRequest = new BlpRequest();
            BlpSecurity security = new BlpSecurity();
            security.setSecuritySearch(BlpRequestConstants.CHK_BLP_SECURITY_STR);
            tstRequest.addSecurity(security);
            tstRequest.addField(BlpMnemonics.NAME);
            long start = System.currentTimeMillis();
            BlpResult result = getInstance(blpEnabled).sendRequest(tstRequest);
            logger.info("Time taken to run Blp checking request: " + (System.currentTimeMillis() - start));
            Object value = result.getValue(security, BlpMnemonics.NAME);
            if (value.equals(BlpRequestConstants.BLP_ERR_PREFIX + " - " + BlpRequestConstants.BLP_ERR_UNLICENSED)) {
                logger.log(Level.SEVERE, "Blp API service failed check, not available.");
                return false;
            }
            logger.log(Level.INFO, "Blp API service check OK, is available.");
            return true;
        }
        logger.log(Level.SEVERE, "Blp Service not enable.");
        return false;
    }

    public BlpResult sendRequest(BlpRequest request) throws BlpApiException {
        if (blpEnabled && blpService != null) {
            return blpService.sendRequest(request);
        }
        throw new BlpApiException("Blp API Not Available");
    }

    public static void setBloombergEnabled(boolean b) {
        BlpServiceWrapper.blpEnabled = b;
    }
}