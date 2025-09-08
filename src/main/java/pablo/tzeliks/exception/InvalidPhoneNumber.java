package pablo.tzeliks.exception;

public class InvalidPhoneNumber extends RuntimeException {
    public InvalidPhoneNumber(String message) {
        super(message);
    }

    public InvalidPhoneNumber(String message, Throwable cause) {
        super(message, cause);
    }
}
