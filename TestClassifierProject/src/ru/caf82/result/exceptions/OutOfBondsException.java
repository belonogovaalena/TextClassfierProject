package ru.caf82.result.exceptions;

/**
 *
 * @author Алена
 */
public class OutOfBondsException  extends Exception {
    
    public OutOfBondsException() {
       super();
    };
    
    public OutOfBondsException(String message) {
        super(message);
    };
    
    public OutOfBondsException(String message, Throwable cause) {
        super(message, cause);
    };
    
    public OutOfBondsException(Throwable cause) {
        super(cause);
    }; 
}