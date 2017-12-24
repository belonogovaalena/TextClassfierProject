package ru.caf82.result.exceptions;

/**
 *
 * @author Алена
 */
public class InconveninentShapeException extends Exception {
    
    public InconveninentShapeException() {
       super();
    };
    
    public InconveninentShapeException(String message) {
        super(message);
    };
    
    public InconveninentShapeException(String message, Throwable cause) {
        super(message, cause);
    };
    
    public InconveninentShapeException(Throwable cause) {
        super(cause);
    };
}