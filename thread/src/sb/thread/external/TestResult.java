package sb.thread.external;

import java.io.Serializable;

/**
 * @author TReid
 */
public class TestResult implements Serializable {
	
    private TestQuery query = null;

    public TestResult(TestQuery query, Object result) {
    	this.query = query;
    }
    public TestResult (TestQuery query, Object[] results) {
        this.query = query;
        for (int i = 0; i < results.length; i++) {
            // process the results
        }
    }

    public TestResult () {
    }

    public TestQuery getQuery () {
        return query;
    }
    public void setQuery (TestQuery query) {
        this.query = query;
    }
    
    public String toString() {
    	if (query!=null)
    		return "TestResult(" + query.queryId + ")";
    	else
    		return super.toString();
    }
}
