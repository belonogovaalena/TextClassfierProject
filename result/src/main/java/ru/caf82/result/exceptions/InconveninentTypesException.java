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
