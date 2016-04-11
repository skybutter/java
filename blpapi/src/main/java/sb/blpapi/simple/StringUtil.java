package sb.blpapi.simple;

public class StringUtil {
	
    public static boolean isEmptyString(String s) {
        return s == null || s.trim().equals("");
    }
}
