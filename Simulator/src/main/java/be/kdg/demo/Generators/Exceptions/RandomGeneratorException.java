package be.kdg.demo.Generators.Exceptions;

public class RandomGeneratorException extends RuntimeException {
    public RandomGeneratorException(String message) {
        super(message);
    }

    public RandomGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }
}
