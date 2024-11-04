package exception;

public class TimException extends Exception{

    public TimException(String message) {
        super(message);
    }

    public TimException(Throwable cause) {
        super(cause);
    }

    public TimException(String message, Throwable cause) {
        super(message, cause);
    }
}
