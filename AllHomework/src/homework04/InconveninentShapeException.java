package homework04;

/**
 *
 * @author Алена
 */

//исключение, возникающее в dotProduct, когда на вход поступают массивы,
//размеры которых не позволяют их перемножить
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