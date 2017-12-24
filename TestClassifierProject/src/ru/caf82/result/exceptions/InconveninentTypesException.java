package ru.caf82.result.exceptions;

/**
 *
 * @author Алена
 */
public class InconveninentTypesException extends Exception {
    
    public InconveninentTypesException() {
       super();
    };
    
    public InconveninentTypesException(String message) {
        super(message);
    };
    
    public InconveninentTypesException(String message, Throwable cause) {
        super(message, cause);
    };
    
    public InconveninentTypesException(Throwable cause) {
        super(cause);
    };
}
