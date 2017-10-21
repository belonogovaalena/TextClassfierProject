/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.machinelearning.preprocessing;

import Exeptions.EmptyArrayException;
import Exeptions.InconveninentShapeException;
import Exeptions.ModelNotFittedException;
import java.io.Serializable;
import java.util.Random;
import Other.MathService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LogisticRegression implements MlModel, Serializable {
//private float alpha;
//private float betta;
//private boolean parralize;
//private float learnRate;
//private Random initializer = new Random();
private int ITERATES=1000;
private double rate=0.001;

private double[] weights;
//private boolean fitted = false;

  // public LogisticRegression2(float alpha, float betta, int maxIter, float learnRate, boolean parralize) {}
   public static double sigmoid(double z){
       return 1/(1+Math.exp(-z));
   }
    /**
     * Инициализация массива векторв - нужно добавить первый столбец с одними единицами
     * @param X - координаты векторов
     * @return 
     */
   static public double[][] init(double[][]X){
       int i,j;
       double [][]Y=new double[X.length][X.length+1];
       for(i=0;i<X.length;i++){
           Y[i][1]=1;
           for(j=1;j<X[i].length+1;j++)Y[i][j]=X[i][j];
       }
       return Y;
   };
   /**
    * Тренировка весов
    * С каждой итерацией вероятность будет точнее и точнее
    * @param X полученные вектора из CountVectorizer
    * @param y возможные варианты (1 или 0)
     * @return 
    * @throws InconveninentShapeException
    * @throws EmptyArrayException 
    */
@Override
   public MlModel train(double[][] X, int[] y) throws InconveninentShapeException {
       double pr=0;
       double []sumdelta; //сумма дельт в каждом столбце
       int i,j;
       weights=new double[X[1].length+1];
       X=init(X);
       double delta[];
       sumdelta=new double[X.length];
       for(int u=0;u<ITERATES;u++){
           delta=new double[X.length];
           for(i=0;i<X.length;i++){             
               try {
                   pr=sigmoid(MathService.doProduct(X[i], weights));
               } catch (EmptyArrayException ex) {
                   Logger.getLogger(LogisticRegression.class.getName()).log(Level.SEVERE, null, ex);
               }
               for(j=0;j<X[i].length;j++)delta[i]=(pr-y[i])*X[i][j];
               for(i=0;i<X.length;i++) sumdelta[i]=sumdelta[i]+delta[i];
       }
           for(i=0;i<X.length;i++) sumdelta[i]=sumdelta[i]/X.length;
           for(i=0;i<X.length;i++)weights[i]=weights[i]-rate*sumdelta[i];
       }
       return new MlModel() {
           @Override
           public MlModel train(double[][] X, int[] y) throws InconveninentShapeException {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public int[] predict(double[] X) throws ModelNotFittedException, InconveninentShapeException {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void saveToFile(String filename) throws IOException {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       };
   }
   /**
    * Вспомогательный класс, который помогает вычислить сумму произведений координат вектора их весов
    * @param X вектор
    * @return
    */
   public double ss(double[] X){
      double result=0;
       for(int i=0;i<X.length;i++)result=result+X[i]*weights[i];
       return result;
   }
   /**
    * 
    * @param X
    * @return
     * @throws Exeptions.ModelNotFittedException
    * @throws InconveninentShapeException 
    */
@Override
   public int[] predict(double[] X) throws ModelNotFittedException, InconveninentShapeException {
       double ver=0;
       int []probability=new int[X.length];
       ver =Math.exp(ss(X))/(1+Math.exp(ss(X)));
       if(ver>0.5){
           System.out.println("It is a dog");
           probability[0]=1;
       }else if(ver<0.4)System.out.println("It is a cat");
       else System.out.println("I don't know");
       return probability;
   }

    @Override
    public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
//   public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {}
//   public void saveToFile(String filename) throws IOException {}
//   public double[] getWeights() {}
//   public float getAlpha() {}
//   public void setAlpha(float alpha) {}
//   public float getBetta() {}
//   public void setBetta(float betta) {}
//   public int getMaxIter() {}
//   public void setMaxIter(int maxIter) {}
//   public boolean isParralize() {}
//   public void setParralize(boolean parralize) {}
//   public float getLearnRate() {}
//   public void setLearnRate(float learnRate) {}
//   private double lossFunction(double[][] X, double[] W, int[] y) throws InconveninentShapeException {}
//   private double[] lossFunctionDerivative(double[][] X, double[] W,
//                                           int[] y, float alpha, float betta) throws InconveninentShapeException {}
//}
