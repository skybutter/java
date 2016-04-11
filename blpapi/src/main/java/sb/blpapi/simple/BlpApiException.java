package sb.blpapi.simple;

public class BlpApiException extends Exception {
    public static final String DATE_NULL = "Date is null";

    public BlpApiException (String message) {
        super(message);
    }
}
