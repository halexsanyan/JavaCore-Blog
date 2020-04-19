package blog.exception;

public class ModelNodFoundException extends Exception {
    public ModelNodFoundException() {
    }

    public ModelNodFoundException(String message) {
        super(message);
    }

    public ModelNodFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelNodFoundException(Throwable cause) {
        super(cause);
    }

    public ModelNodFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
