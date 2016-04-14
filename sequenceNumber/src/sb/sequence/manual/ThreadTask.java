package sb.sequence.manual;

import java.sql.SQLException;
import java.util.concurrent.Callable;

public class ThreadTask implements Callable<Integer> {
	
	public String sequence;
	
	public Integer call() {
		int value = 0;
		try {
			int reserveSize = 1;
			value = SequenceManager.getInstance().getNextVal(sequence, reserveSize);
			System.out.println(System.currentTimeMillis() + " ThreadTask: key=" + sequence + " , value=" + value);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
}
