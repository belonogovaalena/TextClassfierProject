package ru.caf82.result.workwithfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ru.caf82.result.machinelearning.models.MlModel;
/**
 * Created by ilysko on 03.08.17.
 */
public class FileReader implements FileWorker {
     public static String readFrom (String pathToFile) {
        String textString = "";
         try(FileInputStream reader = new FileInputStream(pathToFile))
        {
            byte[] arByte = new byte[reader.available()];
            reader.read(arByte);
            textString = new String(arByte);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally { 
            return textString;
         }
    }
     
     public static void saveMlModelToFile (MlModel model) throws IOException {
         FileOutputStream fos = new FileOutputStream("MlModel.out");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(model);
         oos.flush();
         oos.close();
         
     }
     public static MlModel loadMlModelToFile () throws IOException, ClassNotFoundException {
         FileInputStream fis = new FileInputStream("MlModel.out");
         ObjectInputStream oin = new ObjectInputStream(fis);
         MlModel model = (MlModel)oin.readObject();
         return model;
     }
     
     
    public static void main(String[] args) {
       /* String directory = "C:\\SomeDir\\notes3.txt";
        String textFromFile = readFrom(directory);
        System.out.println(textFromFile);
        */
    }
}
