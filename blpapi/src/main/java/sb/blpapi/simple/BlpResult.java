package sb.blpapi.simple;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BlpResult {
    private Map<BlpSecurity, Map<String, Object>> resultMap = new ConcurrentHashMap<BlpSecurity, Map<String, Object>>();
    private BlpRequest request = null;

    public BlpResult (BlpRequest request, Map<String, Map<String, Object>> results) {
        this.request = request;
        for (BlpSecurity security : request.getSecurities()) {
        	String securityString = security.getSecuritySearch();
        	Map<String, Object> fieldsValues = results.get(securityString);
        	if (security!=null && fieldsValues!=null)
        		resultMap.put(security, fieldsValues);
        }
    }

    public Collection<BlpSecurity> getSecurities () {
        if (request == null) {
            return Collections.emptyList();
        }
        return request.getSecurities();
    }

    public Collection<String> getFields () {
        if (request == null) {
            return Collections.emptyList();
        }
        return request.getFields();
    }

    public Object getValue (BlpSecurity security, String field) {
        Map<String, Object> obj = getValues(security);
        if (obj != null) {
            return obj.get(field);
        } else {
            return null;
        }
    }

    public Map<String, Object> getValues(BlpSecurity security) {
        Map<String, Object> testMap = resultMap.get(security);
        if (testMap != null && testMap.size() > 0) {
            Object testVal = testMap.get(testMap.keySet().iterator().next());
            // test to see if this is a bad security
            if (testVal == null || testVal.equals(BlpRequestConstants.BLP_ERR_BADSECURITY)) {
                return null;
            }
        }
        return testMap;
    }

    public static boolean isValidValue (Object value) {
        return value != null && !value.toString().trim().equals("") 
            && !value.toString().trim().startsWith(BlpRequestConstants.BLP_ERR_PREFIX);
    }

    public String toString () {
        StringBuffer buf = new StringBuffer();
        Iterator secIter = getSecurities().iterator();
        while (secIter.hasNext()) {
            BlpSecurity security = (BlpSecurity) secIter.next();
            buf.append('\n');
            buf.append(security);
            Map values = getValues(security);
            Iterator valIter = values.keySet().iterator();
            while (valIter.hasNext()) {
                Object field = valIter.next();
                Object value = getValue(security, (String) field);
                buf.append('\n');
                buf.append('\t');
                buf.append(((String) field).trim());
                buf.append(" = ");
                buf.append(value);
            }
            buf.append('\n');
        }
        if (request!=null && request.isHistoricalRequest()) {
        	buf.append("Historical Date = " + request.getHistoricalDate() + "\n");
        }
        return buf.toString();
    }

    public void setQuery (BlpRequest query) {
        this.request = query;
    }

    public Map<BlpSecurity, Map<String, Object>> getResultMap () {
        return resultMap;
    }

    public void setResult (BlpSecurity security, String mnemonic, Object val) {
        Map<String, Object> resultMapForSecurity = resultMap.get(security);
        if (resultMapForSecurity == null) {
            Map<String, Object> newResultMapForSecurity = new ConcurrentHashMap<String, Object>();
            resultMapForSecurity = resultMap.put(security, newResultMapForSecurity);
        }
        resultMapForSecurity.put(mnemonic, val);
    }
}
