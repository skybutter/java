package sb.sequence.manual;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a simple implementation of Data Access Object.
 * In real application, this should be getting connection from connection pool,
 * such as J2EE servers, Apache Commons DBCP, etc...
 * @author AWong
 *
 */
public class SequenceJdbcDao implements ISequenceDao {

	private static final Logger logger = Logger.getLogger(SequenceJdbcDao.class.getName());
	
	private static String jdbcDriver = "com.sybase.jdbc4.jdbc.SybDriver";
	private static String jdbcUrl = "jdbc:sybase:Tds:localhost:2638/yourdb";
	private static String user = "username";
	private static String password = "password";
	
	private Connection connection = null;
			
	public int getNextVal(String sequence, int reserveSize) throws java.sql.SQLException {
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareCall("{call get_next_sequence (?, ?, ?)}");
			stmt.setString(1, sequence);
			stmt.registerOutParameter(2, Types.INTEGER);
			stmt.setInt(3, reserveSize); 
			stmt.execute();
			return stmt.getInt(2);
		} finally {
			closeRs(rs);
			closeStmt(stmt);
		}
	}
	
	private void initConnection() throws SQLException {
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, "Error loading JDBC Driver.", e);
			throw new SQLException(e.getMessage(), e);
		}
	}
	
	private Connection getConnection() throws SQLException {
		if (connection==null || connection.isClosed()) {
			initConnection();
		}
		return connection;
	}

    protected void closeStmt(Statement stmt ) {
        if (stmt == null) {
            return;
        }
        try {
            stmt.close();
        } catch (Exception e) {
            // ignore closing exception
        }
    }
    protected void closeRs(ResultSet res) {
        if (res== null) {
            return;
        }
        try {
            res.close();
        } catch (Exception ignore) {
        	// ignore closing exception
        }
    }
    public void closeConnection() {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (Throwable t) {
            logger.log(Level.SEVERE, "Error closing connection.", t);
        } finally {
        	connection = null;
        }
    }
}
