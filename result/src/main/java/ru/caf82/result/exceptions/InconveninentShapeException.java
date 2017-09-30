/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
