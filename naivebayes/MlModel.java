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
public interface MlModel {
    MlModel train(double[][] X, int[] y) throws InconveninentShapeException;

   int[] predict(double[] X) throws ModelNotFittedException, InconveninentShapeException;

   double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException;


   void saveToFile(String filename) throws IOException;

        
}
