package sb.blpapi.simple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyTest {

    protected static String translateToBBString (Object val) throws BlpApiException {
        if (val instanceof Date) {
            try {
                return new SimpleDateFormat("yyyyMMdd").format((Date) val);
            } catch (NullPointerException npe) {
                throw new BlpApiException(BlpApiException.DATE_NULL);
            }
        }
        return val.toString();
    }    

    public static void main(String[] args) throws BlpApiException {
    	//Date value = null;
    	//translateToBBString (value);
    	String[] strArray = new String[] {"abc", "def", "ghi"};
    	System.out.println("strArray.length=" + strArray.length);
    	ArrayList<String> strList = new ArrayList<String>();
    	strList.add("abc");
    	strList.add("def");
    	strList.add("ghi");
    	System.out.println("strList.size()=" + strList.size());
    	String[] strArray2 = new String[3];
    	strArray2[0] = "abc";
    	strArray2[1] = "def";
    	strArray2[2] = "ghi";
    	System.out.println("strArray2.length=" + strArray2.length);
    }
}
