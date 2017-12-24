package ru.caf82.result.others;

import ru.caf82.result.exceptions.InconveninentShapeException; 
import java.util.List; 
import java.util.Map; 
import ru.caf82.result.exceptions.ModelNotFittedException;
import ru.caf82.result.machinelearning.preprocessing.CountVectorizer; 
import ru.caf82.result.machinelearning.models.LogisticRegression; 
import ru.caf82.result.machinelearning.models.NaiveBayes;
import ru.caf82.result.workwithfiles.FileRead;

public class Worker { 
public static void main(String[] args) throws InconveninentShapeException, ModelNotFittedException { 
    LogisticRegression logisticRegression = new LogisticRegression(); 
    FileRead reading = new FileRead(); 
    Map res = reading.readFile(109, 60); 
    CountVectorizer countVectorizer = new CountVectorizer(res); 
    List<List<Integer>> vectors = countVectorizer.transform(); 
    NaiveBayes nb = new NaiveBayes();
    nb.train(vectors, countVectorizer.getTextClasses());
    nb.predict(vectors);
    logisticRegression.train(vectors, countVectorizer.getTextClasses()); 
    logisticRegression.predict(vectors); 
} 
}