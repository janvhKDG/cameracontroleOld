package kdg.be.demo.FineCalculators.Exceptions;

public class FineCalculatorException extends RuntimeException {
    public FineCalculatorException(String message) {
        super(message);
    }

    public FineCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
