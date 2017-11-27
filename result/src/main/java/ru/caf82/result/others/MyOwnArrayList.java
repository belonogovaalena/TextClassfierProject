
package ru.caf82.result.others;

import java.lang.reflect.Array;
import java.util.Iterator;
import ru.caf82.result.exceptions.InconveninentTypesException;
import ru.caf82.result.exceptions.OutOfBondsException;


public class MyOwnArrayList<T> implements Iterable<T> {
    
    private T[] inner;
    private Class<?> innerClass;
    private int size;
    private int capacity;
    
    MyOwnArrayList() {
       size = 0;
       capacity = 10;
    }
    
    MyOwnArrayList(int cap) {
        size = 0;
        capacity = cap;
    }
    
    MyOwnArrayList(Class<?> inC) {
        size = 0;
        innerClass = inC;
        capacity = 10;
    }
    public void add (T value) throws InconveninentTypesException {
      
      if (innerClass==null)
          innerClass = value.getClass();
      else
          if (value.getClass()!=innerClass)
              throw new InconveninentTypesException("Добавленный элемент не соответсвует содержимому MyOwnArrayList");
      size++;
      T[] oldInner = (T[])Array.newInstance(innerClass, size-1);
      oldInner = inner;
      if (size>capacity) 
          ensureCapacity((capacity*3)/2+1);
      inner = (T[])Array.newInstance(innerClass, capacity);
      for (int i = 0; i<size-1; i++)
          inner[i]=oldInner[i];
      inner[size-1] = value;
      }
     
    
    
    public void add (T value, int position) throws InconveninentTypesException, OutOfBondsException {
        if ((position>=size)|(position<0))
            throw new OutOfBondsException("Выбранная позиция выходит за предел");
        if (innerClass==null)
          innerClass = value.getClass();
        else
            if (value.getClass()!=innerClass)
                throw new InconveninentTypesException("Добавленный элемент не соответсвует содержимому MyOwnArrayList");
        size++; 
        T[] oldInner = (T[])Array.newInstance(innerClass, size-1);
        oldInner = inner;
        if (size>capacity) 
            ensureCapacity((capacity*3)/2+1);
        inner = (T[])Array.newInstance(innerClass, capacity);
        for (int i = 0; i<position; i++)
            inner[i]=oldInner[i];
        inner[position] = value;
        for (int j=position+1; j<size; j++)
            inner[j] = oldInner[j-1];
        }
    
    public void ensureCapacity (int testCap) {
        if (capacity<testCap)
            capacity = testCap;
    }
    
    public int indexOf (T value) {
       for (int i=0; i<size; i++)
           if (inner[i]==value)
            return i;
       return -1;
    }
    
    public boolean contains (T value) {
        int isContains = indexOf(value);
        if (isContains>0) 
            return true;
        else
            return false;
    }
    
    public void set (int position, T value) throws OutOfBondsException {
         if ((position>=size)||(position<0))
            throw new OutOfBondsException("Выбранная позиция выходит за предел");
         inner[position] = value;
    }
    
    public void clear () {
        inner = null;
        size = 0;
        innerClass = null;
    }
    
    public void printMyOwnArrayList() {
        System.out.print("{");
        for (int i=0; i<size-1; i++)
            System.out.print(inner[i]+ ", ");
        System.out.print(inner[size-1] + "}\n");
    }
      
    
   
    public static void main(String[] args)  {
        MyOwnArrayList myOwnArrayList = new MyOwnArrayList();
        try {
            System.out.println("Добавляем элементы:");
            myOwnArrayList.add(1);
            myOwnArrayList.printMyOwnArrayList();
            myOwnArrayList.add(2);
            myOwnArrayList.printMyOwnArrayList();
            myOwnArrayList.add(3);
            myOwnArrayList.printMyOwnArrayList();
            myOwnArrayList.add(4);
            myOwnArrayList.printMyOwnArrayList();
            myOwnArrayList.add(5);
            myOwnArrayList.printMyOwnArrayList();
            myOwnArrayList.add(6);
            myOwnArrayList.printMyOwnArrayList();
            //myOwnArrayList.add("lalala"); //выбрасывает ошибку
            System.out.println("Вставим 100 на второе место:");
            myOwnArrayList.add(100, 2);
            //myOwnArrayList.add(100, 20);  //выбрасывает ошибку
            myOwnArrayList.printMyOwnArrayList();
            System.out.println("Вместимость сейчас: ");
            System.out.println(myOwnArrayList.capacity);
            myOwnArrayList.ensureCapacity(15);
            System.out.println("Увеличили вместимоть на 5. Вместимость теперь: ");
            System.out.println(myOwnArrayList.capacity);
            System.out.println("Элемент 4 находится на месте:");
            int num = myOwnArrayList.indexOf(4);
            System.out.println(num);
            System.out.println("Попробуем найти элемент 999:");
            int num1 = myOwnArrayList.indexOf(999);
            System.out.println(num1);
            System.out.println("Находится ли здесь элемент 999?");
            boolean b1 = myOwnArrayList.contains(999);
            System.out.println(b1);
            System.out.println("Находится ли здесь элемент 3");
            boolean b2 = myOwnArrayList.contains(3);
            System.out.println(b2);
            System.out.println("Запишем на третье место 900");
            myOwnArrayList.set(3, 900);
            myOwnArrayList.printMyOwnArrayList();
        } catch (InconveninentTypesException ex) {
            System.out.println(ex.getMessage());
        } catch (OutOfBondsException ex) {
            System.out.println(ex.getMessage());
        }
        Iterator<Integer> iter = myOwnArrayList.iterator();
       while (iter.hasNext())
           System.out.println(iter.next());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int nowPosition;
            @Override
            public boolean hasNext() {
               
                   return nowPosition<size;
            }

            @Override
            public T next() {
                return inner[nowPosition++];                
            }
            
        };
    }
    
}
