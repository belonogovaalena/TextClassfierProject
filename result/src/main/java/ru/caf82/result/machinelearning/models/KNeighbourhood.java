/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.machinelearning.models;

import java.io.IOException;
import ru.caf82.naivebayes.ModelNotFittedException;
import ru.caf82.result.exceptions.InconveninentShapeException;

/**
 *
 * @author Алена
 */
public class KNeighbourhood implements MlModel{

    @Override
    public MlModel train(double[][] X, int[] y) throws InconveninentShapeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] predict(double[] X) throws  InconveninentShapeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] predictProba(double[] X) throws  InconveninentShapeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
