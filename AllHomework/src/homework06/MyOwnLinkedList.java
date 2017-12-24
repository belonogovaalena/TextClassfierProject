package homework06;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Алена
 */

//реализация LinkedList
public class MyOwnLinkedList<T> implements Iterable<T>{
    
    private MyLinkedList<T> first;
    private MyLinkedList<T> last;
    private int size;

    public MyOwnLinkedList() {
        first = last = null;
        size = 0;
    }
    public void add (T value) {
        MyLinkedList mll = new MyLinkedList(value);
        if (last==null) {
            first = mll;
            last = mll;
            first.next =last;
            first.prev = last;
            last.prev = first;
            last.next = first;
        }
        else {
            MyLinkedList saved = last;
            last.next = mll;
            last = mll;
            last.prev = saved;
            first.prev = last;
            last.next = first;
        }
        size++;
    }
    
    public void add (T value, int position) throws Exception {
        if (position==0) 
            addFirst(value);
        else {
            MyLinkedList counter = first;
            if ((position<0)|(position>size+1))
                throw new Exception("Выбранная позиция выходит за предел");
            if (position==size+1)
               addLast(value); 
            else {
                int now = 0;
                MyLinkedList added = new MyLinkedList(value);
                counter = first;
                while (now!=position-1) {
                    now = now + 1;
                    counter = counter.next;
                }
                added.prev = counter;
                added.next = counter.next;
                counter.next = added;  
            }
        }
        size++;
    }
    
    public void addFirst (T value) {
        MyLinkedList mll = new MyLinkedList(value);
        MyLinkedList saved = first;
        mll.next = saved;
        mll.prev = last;
        saved.prev = mll;
        last.next = mll;
        first = mll;
        size++;
    }
    
    public void addLast (T value) {
        add(value);
    }
    
    public void printMyOwnLinkedList() {
        MyLinkedList mll = first;
        int now = 0;
        while (now!=size) {
            System.out.print(mll.element.toString()+ " ");
            mll = mll.next;
            now++;
        }
        System.out.println();
    }
    
    public boolean contains (T value) {
        MyLinkedList mll = first;
        int now = 0;
        while (now!=size) {
            if (mll.element==value) 
                return true; 
            mll = mll.next;
            now++;
        }
        return false;
    }
    
    public void remove () {
        MyLinkedList mustBeDeleted = first;
        first = mustBeDeleted.next;
        first.prev = last;
        last.next = first;
        mustBeDeleted = null;
        size--; 
    }
    
    public void remove (int position) throws Exception {
        if (position==0)
            removeFirst();
        else {
            if ((position<0)||(position>size+1))
                throw new Exception("Выбранная позиция выходит за предел");
            if (position==size+1)
                removeLast();
            else {
                MyLinkedList<T> counter = first;
                int now = 0;
                while (now!=position-1) {
                    now = now + 1;
                    counter = counter.next;
                }
                MyLinkedList mustBeDeleted = counter.next;
                counter.next = mustBeDeleted.next; 
                mustBeDeleted.next.prev = counter;
                mustBeDeleted = null;
                size--;
            }
        }
    }
    
    public void remove (T value) throws Exception {
        MyLinkedList mll = first;
        int position=0;
        if (position >size+1 )
            throw new Exception("Элемент не найден.");
        else {
            while ((mll.element!=value)){
               mll = mll.next;
               position++;
            }
        remove(position);
        }
    }
    
    public void removeFirst () {
        remove();
    }
    
    public void removeLast() {
        MyLinkedList mll = first;
        int now = 0;
        while (now!=size-1) {
            mll = mll.next;
            now++;
        }  
        last = mll.prev;  
        mll.next = null;
        last.next = first;
        first.prev = last;
        size--;
    }
    
    public void set (T value, int position) throws Exception {
        if (position==0)
            first.element = value;
        else {
            MyLinkedList counter = first;
            if ((position<0)||(position>=size))
                throw new Exception("Выбранная позиция выходит за предел");
            int now = 0;
            counter = first;
            while (now!=position) {
                now = now + 1;
                counter = counter.next;
            }
            counter.element = value;
        }
    }
    
    public T peekFirst() {
        return peek();
    }
    
    public T peekLast() {
        if (last.element!=null)
            return last.element;
        else
            return null;
    }
    
    public T peek () {
        if (first.element!=null)
            return first.element;
        else
           return null;
    }
    
    public T poll () {
        T thisElem = peek();
        removeFirst();
        return thisElem;
    }
    
    public T pollFirst() {
        return poll();
    }
    
    public T pollLast() {
        T thisElem = peekLast();
        removeLast();
        return thisElem;
    }
    
    public boolean addAll(int index,Collection<? extends T> collection) {
        T[] mustBeAdded = (T[]) collection.toArray();
        if ((index>size)|(mustBeAdded.length==0))
            return false;
        else {
            MyOwnLinkedList moll = toBond(mustBeAdded);
            if (index==0) {
               MyLinkedList mll = first; 
               first = moll.first;
               moll.last.next = mll;
               mll.prev = moll.last;
               last.next = first;
               first.prev = last;
            }
            else {
                if (index==size) {
                   last.next = moll.first;
                   moll.first.prev = last;
                   last = moll.last;
                   first.prev = last;
                   last.next = first;
                }
                else {   
                    int now = 0;
                    MyLinkedList mll = first;
                    while (now!=index-1) {
                        now++;
                        mll = mll.next;
                    }
                MyLinkedList saved = mll.next;
                mll.next = moll.first;
                moll.first.prev = mll;
                moll.last.next = saved;
                saved.prev = moll.last;
                }
            }
            size = size+mustBeAdded.length;
            return true; 
        }
    }
    
    public boolean addAll (Collection<? extends T> collection) {
        T[] mustBeAdded = (T[]) collection.toArray();
        if (mustBeAdded.length==0)
            return false;
        else
        {
            MyOwnLinkedList moal = toBond(mustBeAdded);
            last.next = moal.first;
            moal.first.prev = last;
            last = moal.last;
            first.prev = last;
            last.next = first;
            size = size+mustBeAdded.length;
            return true;
        }
    }
    
    private MyOwnLinkedList toBond (T[] array) {
        MyOwnLinkedList moll = new MyOwnLinkedList();
        for (int i = 0; i<array.length; i++)
            moll.add(array[i]);
        return moll;    
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyLinkedList<T> nowPosition = first;
            @Override
            public boolean hasNext() {
                return nowPosition.next!=first;
            }

            @Override
            public T next() {
                nowPosition = nowPosition.next;     
                return (T) nowPosition.prev.element;
            }
        };
    }
    
    public class MyLinkedList<T> {
        MyLinkedList<T> next;
        MyLinkedList<T> prev;
        T element;
        public MyLinkedList(T el) {
            element = el;
        }    
    }         
}