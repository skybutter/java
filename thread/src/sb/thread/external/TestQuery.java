/*
 * Created on Mar 7, 2003
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code Template
 */
package sb.thread.external;

import java.io.Serializable;

public class TestQuery implements Serializable {
	public int queryId;
	
	public TestQuery(int queryId) {
		this.queryId = queryId;
	}
}
