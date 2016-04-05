/**
 * Created on Oct 24, 2003
 *
 */
package sb.thread.manual.serial;

import sb.thread.external.TestQuery;
import sb.thread.external.TestResult;

class MethodRequest {
    final static int SYNC_EXECUTE = 0;

    private MethodRequest() {
    }

    /**
     * @param methodType
     *            one of the SYNC_XXXX constants
     * @param query
     *            the bb query
     * @param cookie
     *            number
     */
    MethodRequest (int methodType, TestQuery query, int cookie) {
        this.query = query;
        this.methodType = methodType;
        this.cookie = cookie;
    }

    private int methodType;
    private TestQuery query;
    private TestResult result;
    private TestException exception;
    private int cookie;
    private boolean done;

    /**
     * @return Returns the query.
     */
    public TestQuery getQuery () {
        return query;
    }

    /**
     * @param query
     *            The query to set.
     */
    public void setQuery (TestQuery query) {
        this.query = query;
    }

    /**
     * @return Returns the result.
     */
    public TestResult getResult () {
        return result;
    }

    /**
     * @param result
     *            The result to set.
     */
    public void setResult (TestResult result) {
        this.result = result;
    }

    /**
     * @return Returns the exception.
     */
    public TestException getException () {
        return exception;
    }

    /**
     * @param exception
     *            The exception to set.
     */
    public void setException (TestException exception) {
        this.exception = exception;
    }

    /**
     * @return Returns the methodType.
     */
    public int getMethodType () {
        return methodType;
    }

    /**
     * @param methodType
     *            The methodType to set.
     */
    public void setMethodType (int methodType) {
        this.methodType = methodType;
    }

    /**
     * @return Returns the done.
     */
    public boolean isDone () {
        return done;
    }

    /**
     * @param done
     *            The done to set.
     */
    public void setDone (boolean done) {
        this.done = done;
    }

    /**
     * @return Returns the cookie.
     */
    public int getCookie () {
        return cookie;
    }

    /**
     * @param cookie
     *            The cookie to set.
     */
    public void setCookie (int cookie) {
        this.cookie = cookie;
    }

}
