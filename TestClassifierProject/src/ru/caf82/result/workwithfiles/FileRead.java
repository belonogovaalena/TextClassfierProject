/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.caf82.result.workwithfiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.caf82.result.machinelearning.preprocessing.MlModel;


/**
 *
 * @author User
 */
public class FileRead{
    public Map<String,Boolean>map;
    public Map readFile(int ZeroAmount, int OneAmount){
      String s = "";
      map = new LinkedHashMap<>();
        String path ="C:\\Users\\Алена\\Desktop\\texts\\";
        for(int i=1;i<ZeroAmount;i++){
            try {
                File file =new File(path + "text0_"+i+".txt");
                java.io.FileReader fir = null;
                try {
                    fir = new java.io.FileReader(file);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                }
                if(!file.exists())System.out.println("File no exist");
                StringBuilder sb=new StringBuilder();
                
                BufferedReader br=new BufferedReader(fir);
                
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                map.put(sb.toString(), false);
                
                
            } catch (IOException ex) {
                Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null,ex);
            }
        
        
        }
        for(int i=1;i<OneAmount;i++){
            try {
                File file =new File(path+"text1_"+i+".txt");
                java.io.FileReader fir = null;
                try {
                    fir = new java.io.FileReader(file);
                } catch (FileNotFoundException ex) {
                    System.out.println(ex);
                }
                if(!file.exists())System.out.println("File no exist");
                StringBuffer sb=new StringBuffer();
                
                BufferedReader br=new BufferedReader(fir);
                
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                map.put(sb.toString(), true);
                
                
            } catch (IOException ex) {
                Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null,ex);
            }
       
         
    }
    return map;   
    }
    
    
    
    //метод для десериализации модели
    public static MlModel loadMlModelToFile () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("MlModel.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        MlModel model = (MlModel)oin.readObject();
        return model;
    }
}