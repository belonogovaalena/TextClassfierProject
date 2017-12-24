package ru.caf82.result.machinelearning.models;

import java.io.IOException;
import java.util.List;
import ru.caf82.result.exceptions.InconveninentShapeException;
import ru.caf82.result.exceptions.ModelNotFittedException;
import ru.caf82.result.machinelearning.preprocessing.MlModel;
import ru.caf82.result.workwithfiles.FileWriter;

/**
 *
 * @author Алена
 */
public class NaiveBayes implements MlModel {
   private float alpha;
   private double[][] weights;
   private boolean fitted;
   private boolean parallel;
   double myPredict, znam, a, b;
   public boolean isCat;
   public NaiveBayes(float alpha, boolean parallel) {
       //Миша сказал забить
   }
   
   public NaiveBayes() { 
   }
   
   public double helpTo(List<Integer> X) throws InconveninentShapeException, ModelNotFittedException{
        double znam = 0, a = 0,b = 0;
        if (!isFitted())
            throw new ModelNotFittedException("Модель не обучена");
        if (X.size()!=weights[0].length)
            throw new InconveninentShapeException("Неверные входные параметры");
        for (int i=0; i<X.size(); i++) {
            znam = znam + (weights[0][i]*X.get(i))+(weights[1][i]*X.get(i));
        }
        for (int i=0; i<X.size(); i++) {
            a= a + ((weights[0][i]*X.get(i)*weights[2][0])/(znam));
        }
        for (int i=0; i<X.size(); i++) {
           b = b +((weights[0][i]*X.get(i)*weights[3][0])/(znam));
        }
           if (a>b) {
               myPredict = a;
               isCat = false;
           }
           else {
               myPredict = b;
               isCat = true;
           }
       return myPredict;
   }
   
   
   //миша сказал забить
   public void saveToFile(String filename) throws IOException {
       FileWriter fw = new FileWriter();
       fw.saveMlModelToFile(this);
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

    @Override
    public MlModel train(List<List<Integer>> X, List<Boolean> y) throws InconveninentShapeException {
         //считаем у=0 и y=1
      if (X.size() != y.size()) 
          throw new InconveninentShapeException("Неверные входные параметры.");
      double yZer = 0, yOne = 0;
      for (int i=0; i<y.size(); i++) {
          if (!y.get(i))
              yZer++;
          else
              yOne++;
      }
      double yZerProb = yZer/y.size();
      double yOneProb = yOne/y.size();
      double[] xOneProb = new double[X.get(1).size()];
      double[] xZerProb = new double[X.get(1).size()];
      
      //считаем апостериорные вероятности
      for (int j=0; j<X.get(1).size(); j++) {
          double xZer=0, xOne = 0;
          for (int k=0; k<X.size(); k++) {
              if ((X.get(k).get(j)>0) && (y.get(k)))
                 xOne=xOne+X.get(k).get(j);
              if ((X.get(k).get(j)>0) && (!y.get(k)))
                  xZer=xZer+X.get(k).get(j);
          }
          xOneProb[j] = xOne/yOne;
          xZerProb[j] = xZer/yZer;
      }
      weights = new double[4][];
      weights[0] = new double[X.get(1).size()];
      weights[1] = new double[X.get(1).size()];
      weights[2] = new double[1];
      weights[3] = new double[1];
      
      for (int k=0; k<X.get(1).size(); k++) {
         weights[0][k] = xOneProb[k];
         weights[1][k] = xZerProb[k];
      }
      weights[2][0] = yOneProb;
      weights[3][0] = yZerProb;
      fitted = true;
      return this;
    }

    @Override
    public int[] predict(List<List<Integer>> X) throws ModelNotFittedException, InconveninentShapeException {
        int[] array = new int[X.size()];
        double[] arr = new double[X.size()];
        for (int i = 0; i<X.size(); i++) {
           arr[i] =  helpTo(X.get(i));
           if (arr[i]<0.44) {
               System.out.print("Текст " + i  +"о кошках ");
           } else {
             System.out.print("Текст " + i  +"о собаках ");  
           }
            System.out.println(arr[i]);
           if (arr[i]<0.44) {
               array[i] = 0;
           }
           else {
               array[i] = 1;
           }
        }
        return array;
    }

    @Override
    public double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException {
       return null;
    }
}
