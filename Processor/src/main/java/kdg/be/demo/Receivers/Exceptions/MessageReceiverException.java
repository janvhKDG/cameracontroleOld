package kdg.be.demo.Receivers.Exceptions;

public class MessageReceiverException extends RuntimeException {
    public MessageReceiverException(String message) {
        super(message);
    }

    public MessageReceiverException(String message, Throwable cause) {
        super(message, cause);
    }
}
