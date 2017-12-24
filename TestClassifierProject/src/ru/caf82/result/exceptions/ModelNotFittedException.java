package ru.caf82.result.exceptions;

/**
 *
 * @author Алена
 */
public class ModelNotFittedException extends Exception {
    public ModelNotFittedException() {
        super();
    }
    public ModelNotFittedException(String message) {
        super(message);
    }
    public ModelNotFittedException(Throwable cause) {
        super(cause);
    }
    public ModelNotFittedException(Throwable cause, String message) {
        super(message);
    }
}