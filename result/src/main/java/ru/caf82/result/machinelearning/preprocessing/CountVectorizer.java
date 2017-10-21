/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.machinelearning.preprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */

    public class CountVectorizer implements SequenceProcessor, Transformer{
private Map<String, Integer> matrix = new HashMap<>(); 
private String[] stopWords; 
final float minDf; 
final float maxDf; 
final boolean parralize; 
private static List<String> defaultStopWordsList = new ArrayList<String>( 
Arrays.asList(new String[]{ 
"а","е","и","ж","м","о","на","не","ни","об","но","он","мне","мои","мож","она","они","оно", 
"мной","много","многочисленное","многочисленная","многочисленные","многочисленный", 
"мною","мой","мог","могут","можно","может","можно","мор","моя","моё","мочь","над","нее", 
"оба","нам","нем","нами","ними","мимо","немного","одной","одного","менее","однажды","однако", 
"меня","нему","меньше","ней","наверху","него","ниже","мало","надо","один","одиннадцать","одиннадцатый", 
"назад","наиболее","недавно","миллионов","недалеко","между","низко","меля","нельзя","нибудь", 
"непрерывно","наконец","никогда","никуда","нас","наш","нет","нею","неё","них","мира","наша", 
"наше","наши","ничего","начала","нередко","несколько","обычно","опять","около","мы","ну","нх","от","отовсюду", 
"особенно","нужно","очень","отсюда","в","во","вон","вниз","внизу","вокруг","вот","восемнадцать", 
"восемнадцатый","восемь","восьмой","вверх","вам","вами","важное","важная","важные","важный","вдали","везде", 
"ведь","вас","ваш","ваша","ваше","ваши","впрочем","весь","вдруг","вы","все","второй","всем","всеми","времени","время", 
"всему","всего","всегда","всех","всею","всю","вся","всё","всюду","г","год","говорил","говорит","года","году","где", 
"да","ее","за","из","ли","же","им","до","по","ими","под","иногда","довольно","именно","долго","позже", 
"более","должно","пожалуйста","значит","иметь","больше","пока","ему","имя","пор","пора","потом","потому","после", 
"почему","почти","посреди","ей","два","две","двенадцать","двенадцатый","двадцать","двадцатый", 
"двух","его","дел","или","без","день","занят","занята","занято","заняты","действительно","давно", 
"девятнадцать","девятнадцатый","девять","девятый","даже","алло","жизнь","далеко","близко","здесь","дальше","для", 
"лет","зато","даром","первый","перед","затем","зачем","лишь","десять","десятый","ею","её","их","бы","еще","при", 
"был","про","процентов","против","просто","бывает","бывь","если","люди","была","были","было","будем","будет","будете","будешь", 
"прекрасно","буду","будь","будто","будут","ещё","пятнадцать","пятнадцатый","друго","другое","другой","другие","другая","других","есть","пять", 
"быть","лучше","пятый","к","ком","конечно","кому","кого","когда","которой","которого","которая","которые","который","которых","кем", 
"каждое","каждая","каждые","каждый","кажется","как","какой","какая","кто","кроме","куда","кругом","с","т","у","я", 
"та","те","уж","со","то","том","снова","тому","совсем","того","тогда","тоже","собой","тобой","собою","тобою", 
"сначала","только","уметь","тот","тою","хорошо","хотеть","хочешь","хоть","хотя","свое","свои","твой","своей","своего","своих", 
"свою","твоя","твоё","раз","уже","сам","там","тем","чем","сама","сами","теми","само","рано","самом","самому", 
"самой","самого","семнадцать","семнадцатый","самим","самими","самих","саму", 
"семь","чему","раньше","сейчас","чего","сегодня","себе","тебе","сеаой","человек","разве","теперь","себя","тебя","седьмой","спасибо", 
"слишком","так","такое","такой","такие","также","такая","сих","тех","чаще","четвертый","через","часто","шестой","шестнадцать","шестнадцатый", 
"шесть","четыре","четырнадцать","четырнадцатый","сколько","сказал","сказала","сказать", 
"ту","ты","три","эта","эти","что","это","чтоб","этом","этому","этой","этого","чтобы","этот","стал","туда", 
"этим","этими","рядом","тринадцать","тринадцатый","этих","третий","тут","эту","суть","чуть","тысяч" 
}) 
); 

/** 
* Заполняет матрицу 
* @see CountVectorizer#matrix слова и возвращает список Мапов 
* @param listOfTexts Список текстов 
* @return Список Мапов 
*/ 
@Override 
public List<Map<String, Integer>> fitAndTransform(List<String> listOfTexts) { 
List<Map<String, Integer>> listOfMaps = new ArrayList<>(); 
for (String text : listOfTexts) { 
List<String> list = preprocess(text); 
listOfMaps.add(countWordsAndEditMatrix(list)); 
} 
return listOfMaps; 
} 

/** 
* Заполняет матрицу 
* @see CountVectorizer#matrix словами из списка текстов 
* @param listOfTexts Список текстов 
*/ 
@Override 
public void fit(List<String> listOfTexts) { 
for (String text : listOfTexts) { 
List<String> list = preprocess(text); 
countWordsAndEditMatrix(list); 
} 
} 

/** 
* Метод извлекающий слова из переданного в метод текста. 
* Не учитываются слова поля из 
* @see CountVectorizer#defaultStopWordsList 
* Используется класс 
* @see PorterStemmer для стемминга 
* @param text Текст, из которого извлекаются слова 
* @return Список слов 
*/ 
@Override 
public List<String> preprocess(String text) { 
PorterStemmer stemmer = new PorterStemmer(); 
text = text.toLowerCase().replaceAll("[^а-я -]","").replaceAll(" +-"," ").replaceAll("- +"," "); 

String[] array = text.split(" +"); 
for (int i = 0; i<array.length; i++) { 
array[i] = stemmer.stem(array[i]); 
} 
List<String> list = new ArrayList<String>(Arrays.asList(array)); 
list.removeAll(defaultStopWordsList); 
return list; 
} 

/** 
* Возвращает список Мапов из слов, взятых из переданного списка текстов 
* @param listOfTexts Список текстов 
* @return Список Мапов 
*/ 
@Override 
public List<Map<String, Integer>> transform(List<String> listOfTexts) { 
List<Map<String, Integer>> listOfMaps = new ArrayList<>(); 
for (String text : listOfTexts) { 
List<String> list = preprocess(text); 
listOfMaps.add(countWords(list)); 
} 
return listOfMaps; 
} 

/** 
* Два конструктора 
*/ 
public CountVectorizer(float minDf, float maxDf, String[] stopWords, boolean parralize) { 
this.minDf = minDf; 
this.maxDf = maxDf; 
this.stopWords = stopWords; 
this.parralize = parralize; 
} 
public CountVectorizer(float minDf, float maxDf) { 
this.minDf = minDf; 
this.maxDf = maxDf; 
parralize = false; 
} 
public CountVectorizer(String[] stopWords) { 
this.stopWords = stopWords; 
minDf = 1; 
maxDf = 1; 
parralize = false; 
} 
public CountVectorizer() { 
minDf = 1; 
maxDf = 1; 
parralize = false; 
} 

/** 
* Геттеры для полей 
* @see CountVectorizer#minDf и 
* @see CountVectorizer#maxDf 
*/ 
public float getMinDf() { 
return minDf; 
} 
public float getMaxDf() { 
return maxDf; 
} 

/** 
* Считает, сколько раз встретилось одно слово в переданном списке слов 
* @param words Список слов, в котором счиатем слова 
* @return Map, в котором ключ - это слово, значение - сколько раз встретилось данное слово 
*/ 

private Map<String, Integer> countWords(List<String> words) { 
Map<String, Integer> map = new HashMap<String, Integer>(); 
int value = 1; 
for (String word : words) { 
if (map.containsKey(word)) { 
value += map.get(word); 
} 

map.put(word, value); 
} 
return map; 
} 

/** 
* Делаем то же самое, что и в методе 
* @see CountVectorizer#countWords(List), но еще и добавляем это в матрицу 
* @see CountVectorizer#matrix 
* @param words Список слов, в котором счиатем слова 
* @return Map, в котором ключ - это слово, значение - сколько раз встретилось данное слово 
*/ 
private Map<String, Integer> countWordsAndEditMatrix(List<String> words) { 
Map<String, Integer> map = countWords(words); 
int valueFromMatrix = 0; 
for (Map.Entry<String,Integer> pair : map.entrySet()) { 
String key = pair.getKey(); 
if (matrix.containsKey(key)) { 
valueFromMatrix = matrix.get(key); 
} 
matrix.put(key, valueFromMatrix + pair.getValue()); 
} 
return map; 
} 

}
