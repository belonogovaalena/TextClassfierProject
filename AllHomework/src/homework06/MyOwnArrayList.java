package homework06;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 *
 * @author Алена
 */

//реализация ArrayList
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
    public void add (T value) throws Exception {  
        if (innerClass==null)
            innerClass = value.getClass();
        else
            if (value.getClass()!=innerClass)
                throw new Exception("Добавленный элемент не соответсвует содержимому MyOwnArrayList");
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
    
    public void add (T value, int position) throws Exception, Exception {
        if ((position>=size)|(position<0))
            throw new Exception("Выбранная позиция выходит за предел");
        if (innerClass==null)
          innerClass = value.getClass();
        else
            if (value.getClass()!=innerClass)
                throw new Exception("Добавленный элемент не соответсвует содержимому MyOwnArrayList");
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
    
    public void set (int position, T value) throws Exception {
        if ((position>=size)||(position<0))
           throw new Exception("Выбранная позиция выходит за предел");
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