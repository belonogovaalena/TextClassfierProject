package homework04;

/**
 *
 * @author Алена
 */

//исключение, когда на вход поступают пустые массивы
public class EmptyArrayException extends Exception{
    
    public EmptyArrayException() {
       super();
    };
    
    public EmptyArrayException(String message) {
       super(message); 
    };
    
    public EmptyArrayException(String message, Throwable cause) {
        super(message, cause);
    };
    
    public EmptyArrayException(Throwable cause) {
        super(cause);
    };
}
