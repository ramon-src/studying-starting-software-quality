package exceptions;

public class InvalidScoreException extends RuntimeException {

    public InvalidScoreException() {
        super("The score must be greater than 0 and fewer than 10.\n" +
                "And score must be into the max score.");
    }

    public InvalidScoreException(String message) {
        super(message);
    }
}
