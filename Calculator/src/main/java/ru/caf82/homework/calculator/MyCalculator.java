
package ru.caf82.homework.calculator;

/**
 *
 * @author Алена
 */
public class MyCalculator {
    public MyCalculator() {
        
    }
    
    public long add (long x, long y) {
        return x+y;
    }
    
    public long sub (long x, long y) {
        return x-y;
    }
    
    public long div (long x, long y) {
        try {
            return x/y;
        }catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }
    
    public long mult (long x, long y) {
        return x*y;
    }
}
