package homework07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Алена
 */

public class WorkWithFiles{

    //метод для чтения текста из файла
    public static String readFromFile (String pathToFile) {
        String textString = "";
        try(FileInputStream reader = new FileInputStream(pathToFile)) {
            byte[] arByte = new byte[reader.available()];
            reader.read(arByte);
            textString = new String(arByte);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally { 
            return textString;
        }
    }
    
    //метод для сериализации модели
    public static void saveMlModelToFile (MlModel model) throws IOException {
        FileOutputStream fos = new FileOutputStream("MlModel.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(model);
        oos.flush();
        oos.close(); 
    }
    
    //метод для десериализации модели
    public static MlModel loadMlModelToFile () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("MlModel.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        MlModel model = (MlModel)oin.readObject();
        return model;
    }
}