package exceptions;

/**
 * Created by ramon on 11/21/16.
 */
public class DictionaryEmptyException extends RuntimeException {

    public DictionaryEmptyException() {
        super("The returned dictionary cannot be empty");
    }

    public DictionaryEmptyException(String message) {
        super(message);
    }

}
