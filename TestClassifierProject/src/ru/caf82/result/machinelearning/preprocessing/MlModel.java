package ru.caf82.result.machinelearning.preprocessing;

import ru.caf82.result.exceptions.InconveninentShapeException;
import ru.caf82.result.exceptions.ModelNotFittedException;
import java.io.IOException;
import java.util.List;



/**
 *
 * @author User
 */
public interface MlModel {
    MlModel train(List<List<Integer>> X, List<Boolean> y) throws InconveninentShapeException;

   int[] predict(List<List<Integer>> X) throws ModelNotFittedException, InconveninentShapeException;

   double[] predictProba(double[] X) throws ModelNotFittedException, InconveninentShapeException;

   void saveToFile(String filename) throws IOException;   
}