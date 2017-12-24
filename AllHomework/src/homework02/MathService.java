package homework02;

import homework04.EmptyArrayException;
import homework04.InconveninentShapeException;

/**
 *
 * @author Алена
 */
public class MathService {
    
    //static-метод, возвращающий склярное произведение двух векторов
    public static double dotProduct(double[] a, double[] b) throws InconveninentShapeException, EmptyArrayException {
        double result=0;
        if ((a.length==0)||(b.length==0))
            throw new EmptyArrayException("Ошибка! Вектор нулевой длины!");
        else {
            if (a.length!=b.length) 
                throw new InconveninentShapeException("Ошибка! Длина векторов должна быть одинаковой!");
            else {
                for (int i=0; i<a.length; i++) 
                    result+=a[i]*b[i];
                return result;
            }
        }
    }
    
    //static-метод, применяющий к числу сигмоидальную функцию
    public static double sigmoid(double x){
            return (1/(1+Math.exp(-x)));
    }
    
    //static-метод, применяющий к склярному произведению сигмоидальную функцию
    public static double sigmoid(double[] x, double[] w) throws InconveninentShapeException, EmptyArrayException {
        double sclProd = dotProduct(x, w);
        return sigmoid(sclProd);
    }
    
    //функция нормализации вектора
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
    
    //функция нормализации матрицы
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
}   