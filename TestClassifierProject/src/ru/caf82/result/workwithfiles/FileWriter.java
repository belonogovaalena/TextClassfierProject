/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.workwithfiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ru.caf82.result.machinelearning.preprocessing.MlModel;

/**
 *
 * @author Алена
 */
public class FileWriter implements FileWorker{
    //метод для сериализации модели
    public void saveMlModelToFile (MlModel model) throws IOException {
        FileOutputStream fos = new FileOutputStream("MlModel.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(model);
        oos.flush();
        oos.close(); 
    }
}
