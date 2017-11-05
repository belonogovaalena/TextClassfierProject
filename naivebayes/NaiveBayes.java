/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.naivebayes;

import java.io.IOException;
import ru.caf82.result.exceptions.InconveninentShapeException;

/**
 *
 * @author Алена
 */
public class NaiveBayes implements MlModel {
   private float alpha;
   private double[][] weights;
   private boolean fitted;
   private boolean parallel;
   public NaiveBayes(float alpha, boolean parallel) {
       //Миша сказал забить
    }
   public MlModel train(double[][] X, int[] y) throws InconveninentShapeException {
      //считаем у=0 и y=1
      if (X.length != y.length) 
          throw new InconveninentShapeException("Неверные входные параметры.");
      double yZer = 0, yOne = 0;
      for (int i=0; i<y.length; i++) {
          if (y[i]==0)
              yZer++;
          else
              yOne++;
      }
      double yZerProb = yZer/y.length;
      double yOneProb = yOne/y.length;
      double[] xOneProb = new double[X.length];
      double[] xZerProb = new double[X.length];
      
      //считаем апостериорные вероятности
      for (int j=0; j<X[0].length; j++) {
          double xZer=0, xOne = 0;
          for (int k=0; k<X.length; k++) {
              if ((X[k][j]==1)&& (y[k]==1))
                 xOne++;
              if ((X[k][j]==1)&& (y[k])==0)
                  xZer++;
          }
          xOneProb[j] = xOne/yOne;
          xZerProb[j] = xZer/yZer;
      }
      weights = new double[4][];
      weights[0] = new double[X[0].length];
      weights[1] = new double[X[0].length];
      weights[2] = new double[1];
      weights[3] = new double[1];
      for (int k=0; k<X[0].length; k++) {
         weights[0][k] = xOneProb[k];
         weights[1][k] = xZerProb[k];
      }
      weights[2][0] = yOneProb;
      weights[3][0] = yZerProb;
      fitted = true;
      return this;
    }
   public int[] predict(double[] X) throws ModelNotFittedException, InconveninentShapeException {
       double[] wasPredicted = predictProba(X);
       int[] myPredict = new int[X.length];
       for (int i =0; i <X.length; i++) {
           if (wasPredicted[i]<0.5)
            myPredict[i]=0;
           else
               myPredict[i]=1;
       }
       return myPredict;
    }
   public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {
       if (!isFitted())
           throw new ModelNotFittedException("Модель не обучена");
       if (X.length!=weights[0].length)
           throw new InconveninentShapeException("Неверные входные параметры");
       double[] myPredict = new double[X.length];
       for (int i=0; i<X.length; i++) {
           double znam = (weights[0][i]*weights[2][0])+(weights[1][i]*weights[3][0]);
           myPredict[i] = ((weights[0][i]*weights[2][0])/(znam));
       }
       return myPredict;
   }
   
   
   //миша сказал забить
   public void saveToFile(String filename) throws IOException {
   
   }
   
   //миша сказал забить
   public float getAlpha() {
       return 0;
   }
   
   public double[][] getWeights() {
       return weights; 
       
   } 
   public boolean isFitted() {
       return fitted;
     
   }
}
