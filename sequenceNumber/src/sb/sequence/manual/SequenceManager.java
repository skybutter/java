package sb.sequence.manual;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/** 
 * This sequence implementation simulate Oracle sequence number in Sybase or MS SQL.
 * To avoid many hits to the database, the sequence number is cached in memory until used.
 * 
 * Please make sure the database call to acquire the sequence number in the database run its own database transaction. 
 * @author AWong
 */

public class SequenceManager {
	private static final Logger logger = Logger.getLogger(SequenceManager.class.getName()); 
	private static SequenceManager instance = null;
	private static Map<String, SequenceCache> sequenceKeysCache = new HashMap<String, SequenceCache>();
	
	public static SequenceManager getInstance() {
		synchronized (SequenceManager.class) {
			if (instance == null) {
				instance = new SequenceManager();
			}
		}
		return instance;
	}

    private SequenceManager() {
    }
  
	private ISequenceDao getSequenceDao() {
		ISequenceDao dao = new SequenceJdbcDao();
		return dao;
	}
	private void closeDao(ISequenceDao dao) {
		dao.closeConnection();
	}
	

	/**
	 * Get next value from cache if available.  If cache is exhausted, get from sequences table and populate cache
	 * 
	 * @param sequence name used in sequences table
	 * @param reserveSize number of id's to reserve 
	 * 
	 * @return next available sequence number
	 * @throws java.sql.SQLException
	 * 
	 */
	public int getNextVal(String sequence, int reserveSize) throws java.sql.SQLException {
		SequenceCache cache;
		synchronized (sequenceKeysCache) {
			cache = (SequenceCache) sequenceKeysCache.get(sequence);
			if (cache==null) {
				cache = new SequenceCache(sequence);
				sequenceKeysCache.put(sequence,cache);
			} 
		}
		return cache.getNextVal(reserveSize);
    }
    
	/**
	 * This class should support multi-threaded application.
	 * Please be careful with thread.
	 * @author AWong
	 */
    class SequenceCache {
    	private static final int DEFAULT_CACHE_SIZE = 100;
    	String sequence;
    	int nextVal;
    	int avail;
    	
		SequenceCache(String s) {
    		this.sequence=s;
    	}
    	
    	private void ensureCapacity(int reserveSize) throws SQLException {
    		// Verify if cached numbers is enough for request
    		if (reserveSize > avail) {
    			// caller ask for more than available in cache
    			// get more from the data source
    			int cacheSize = DEFAULT_CACHE_SIZE;
    			if (reserveSize>DEFAULT_CACHE_SIZE) {
    				cacheSize=reserveSize;
    			}
    			logger.info("Key=" + sequence + " , nextVal "+this.nextVal);
    			this.nextVal = retrieveNextVal(sequence, cacheSize)-cacheSize;
    			this.avail = cacheSize;
    			logger.info("Allocated "+toString());
    		}
    	}

		/** 
		 * Get next value from source
		 * @param sequence
		 * @param reserveSize
		 * @return
		 * @throws SQLException
		 */
		private int retrieveNextVal(String sequence, int reserveSize) throws SQLException {
			// This needs to run on its own database transaction
			ISequenceDao dao = getSequenceDao();
			try {
				return dao.getNextVal(sequence, reserveSize);
			} finally {
				closeDao(dao);
			}
		}    
		
    	synchronized int getNextVal(int reserveSize) throws SQLException {
    		ensureCapacity(reserveSize);
    		if (avail<=0) {
                throw new IllegalStateException("Unable to return id for "+sequence+". " + this.toString());
            }
    		this.nextVal+=reserveSize;
    		this.avail-=reserveSize;
    		return this.nextVal;
    	}
    	
    	public String toString() {
    		return "sequence="+sequence+", nextVal="+nextVal+", available="+avail;
    	}
    }
}