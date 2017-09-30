
package ru.caf82.result.others;

import java.util.logging.Level;
import java.util.logging.Logger;
import ru.caf82.result.exceptions.EmptyArrayException;
import ru.caf82.result.exceptions.InconveninentShapeException;

/**
 *
 * @author Алена
 */
public class MathService {
    
    public static double dotProduct(double[] a, double[] b) throws InconveninentShapeException, EmptyArrayException {
        double result=0;
            if ((a.length ==0 )|| (b.length== 0))
                throw new EmptyArrayException("Ошибка! Вектор нулевой длины!");
            else {
                if (a.length != b.length) 
            throw new InconveninentShapeException("Ошибка! Длина векторов должна быть одинаковой!");
                else {
                    for (int i=0; i<a.length; i++) 
                        result+=a[i]*b[i];
                        return result;
                    }
                }
    }
    
    public static double sigmoid(double x){
            return (1/(1+Math.exp(-x)));
    }
    
    public static double sigmoid(double[] x, double[] w) throws InconveninentShapeException, EmptyArrayException {
        double sclProd = dotProduct(x, w);
        return sigmoid(sclProd);
    }
    
    public static double[] vectorNormalize (double[] x)  {
        
            double average = 0, denom = 0;
            double[] result = new double[x.length];
            for (int i=0; i<x.length; i++) {
                average+=x[i];
            }
            average=average/x.length;
            for (int j=0; j<x.length; j++) {
                denom+=Math.pow((x[j]-average), 2);
            }
            denom=Math.sqrt(denom/(x.length-1));
            for (int k=0; k<x.length; k++) {
                result[k]= (x[k]-average)/denom;
            }
            return result;
        
    }
    
    public static double[][] matrixNormalize(double[][] x) throws EmptyArrayException  {
        double[][] result = new double[x.length][];
        boolean findException = false;
        for (int j=0; j<x.length; j++) {
           if (x[j].length == 0)
              findException = true; 
        }
        if (findException)
            throw new EmptyArrayException("Ошибка! В матрицу входит нулевая строка!"); 
        else {
            for (int i=0; i<x.length; i++) {
                result[i] = new double [x[i].length];
                result[i] = vectorNormalize(x[i]);
            }
            return result;
        }
    }
            
    public static void main (String[] args) {
        //test for homework#1
        
        /*double[] u = {1.1, -2.0, 6.8}; 
        double[] v = {-0.7, -1.1, 3.0};
        System.out.println("*********************************");
        System.out.println("(1) dotProduct");
        System.out.println("u = ("+u[0]+", "+u[1]+ ", "+u[2] + ")");
        System.out.println("v = ("+v[0]+", "+v[1]+ ", "+v[2] + ")");
        
        System.out.println("(vector1*vector2) = "+ dotProduct(u, v));
        
        System.out.println("*********************************");
        System.out.println("(2) sigmoid");
        double x = 2.3;
        System.out.println("x = " + x); 
        System.out.println("1/(1+exp(-x)) = " + sigmoid(x));
        
        System.out.println("*********************************");
        System.out.println("(3) sigmoid");
        System.out.println("vector1 = ("+u[0]+", "+u[1]+ ", "+u[2] + ")");
        System.out.println("vector2 = ("+v[0]+", "+v[1]+ ", "+v[2] + ")");
        System.out.println("1/(1+exp(-(u*v))) = "+ sigmoid(u,v));
         
        System.out.println("*********************************");
        System.out.println("(4) vectorNormalize");
        System.out.println("u = ("+u[0]+", "+u[1]+ ", "+u[2] + ")");
        double[] w = vectorNormalize(u);
        System.out.println("After normaliztion: u = ("+w[0]+", "+w[1]+ ", "+w[2] + ")");
        
        System.out.println("*********************************");
        System.out.println("(5) matrixNormalize");
        System.out.println("Initial matrix:");
        double[][] inmat = {{1.1, -2.0, 6.8},
                            {5.2, -10, 10},
                            {4.1, -3.9, 10.2}};
        for (int i=0; i<inmat.length; i++) {
            for (int k=0; k<inmat[i].length; k++) {
                System.out.print(inmat[i][k]+" ");
            }
            System.out.println();
        }
        
        double[][] finmat = new double[inmat.length][];
        for (int j=0; j<inmat.length; j++) 
            finmat[j] = new double[inmat[j].length];
        finmat = matrixNormalize(inmat);
        System.out.println("\nAfter normalize:");
        for (int i=0; i<finmat.length; i++) {
            for (int k=0; k<finmat[i].length; k++) {
                System.out.print(finmat[i][k]+" ");
            }
            System.out.println();
        */
        
        //test for homework#4
        double[] a1 = {};
        double[] b1 = {1,2,3};
        try {
            double c = dotProduct(a1, b1);
        } catch (EmptyArrayException ex) {
            System.out.println(ex.getMessage());
        } catch (InconveninentShapeException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("**************************************************************");
        double[] a2 = {1,2,3,4,5};
        double[] b2 = {1,2,3};
        try {
            double c = dotProduct(a2, b2);
        } catch (EmptyArrayException ex) {
            System.out.println(ex.getMessage());
        } catch (InconveninentShapeException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("**************************************************************");
        double[] a3 = {};
        double[] b3 = {1,2,3};
        try {
            double c = sigmoid(a3, b3);
        } catch (EmptyArrayException ex) {
            System.out.println(ex.getMessage());
        } catch (InconveninentShapeException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("**************************************************************");
        double[] a4 = {1,2,3,4,5};
        double[] b4 = {1,2,3};
        try {
            double c = sigmoid(a4, b4);
        } catch (EmptyArrayException ex) {
            System.out.println(ex.getMessage());
        } catch (InconveninentShapeException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("**************************************************************");
        double[][] a5 = {{1,2,3,4},
                        {},
                        {5,6,7,8}};
        double[][] finmat = new double[a5.length][];
        for (int j=0; j<a5.length; j++) 
            finmat[j] = new double[a5[j].length];
        try {
            finmat = matrixNormalize(a5); 
            for (int i=0; i<finmat.length; i++) {
            for (int k=0; k<finmat[i].length; k++) {
                System.out.print(finmat[i][k]+" ");
            }
            System.out.println();
        }
        } catch (EmptyArrayException ex) {
            System.out.println(ex.getMessage());
        }       
    }
}   

