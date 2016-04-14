package sb.sequence.manual;

public interface ISequenceDao {

	public int getNextVal(String sequence, int reserveSize) throws java.sql.SQLException;
	public void closeConnection();
}
