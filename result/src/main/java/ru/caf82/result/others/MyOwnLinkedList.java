
package ru.caf82.result.others;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ru.caf82.result.exceptions.OutOfBondsException;

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
    
    public void add (T value, int position) throws OutOfBondsException {
        if (position==0) 
            addFirst(value);
        else {
            MyLinkedList counter = first;
            if ((position<0)|(position>size+1))
                throw new OutOfBondsException("Выбранная позиция выходит за предел");
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
    
    public void remove (int position) throws OutOfBondsException {
        if (position==0)
            removeFirst();
        else {
        if ((position<0)||(position>size+1))
            throw new OutOfBondsException("Выбранная позиция выходит за предел");
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
    
    public void remove (T value) throws OutOfBondsException {
        MyLinkedList mll = first;
        int position=0;
        if (position >size+1 )
            throw new OutOfBondsException("Элемент не найден.");
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
    
    public void set (T value, int position) throws OutOfBondsException {
        if (position==0)
            first.element = value;
        else {
        MyLinkedList counter = first;
        
        if ((position<0)||(position>=size))
            throw new OutOfBondsException("Выбранная позиция выходит за предел");
       
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

    public static void main(String[] args) {
       try {
           MyOwnLinkedList myOwnLinkedList = new MyOwnLinkedList();
           System.out.println("Добавим элементы: ");
           myOwnLinkedList.add("Apple");
           myOwnLinkedList.add("Bear");
           myOwnLinkedList.add("Candy");
           myOwnLinkedList.add("Door");
           myOwnLinkedList.add("Eagle");
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Есть ли элемент Apple? ");
           boolean isC = myOwnLinkedList.contains("Apple");
           System.out.println(isC);
           System.out.println("Есть ли элемент Discovery? ");
           isC = myOwnLinkedList.contains("Discovery");
           System.out.println(isC);
           System.out.println("Добавим элемент Swan на третье место: ");
           myOwnLinkedList.add("Swan", 3);
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Добавим элемент Handsome в начало: ");
           myOwnLinkedList.addFirst("Handsome");
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Добавим элемент Flu в конец: ");
           myOwnLinkedList.addLast("Flu");
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Удалим первый элемент: ");
           myOwnLinkedList.remove();
           myOwnLinkedList.printMyOwnLinkedList();           
           System.out.println("Добавим элемент Dwarf на четвертую позицию: ");
           myOwnLinkedList.add("Dwarf",4);
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Удалим элемент на позиции 2: ");
           myOwnLinkedList.remove(2);
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Удалим элемент Bear: ");
           myOwnLinkedList.remove("Bear");
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Удалим последний элемент: ");
           myOwnLinkedList.removeLast();
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Заменим второй элемент на Beauty: ");
           myOwnLinkedList.set("Beauty", 2);
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("peek/peek first: " + myOwnLinkedList.peek());
           System.out.println("peek last: " + myOwnLinkedList.peekLast());
           System.out.println("poll/poll first: " + myOwnLinkedList.poll());
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("poll last: " + myOwnLinkedList.pollLast());
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Создадим новую коллекцию: ");
           Collection col1 = new ArrayList();
           col1.add("Liver");
           col1.add("Heart");
           col1.add("Boom");
           System.out.println(col1.toString());
           System.out.println("Вставим ее в конец: ");
           myOwnLinkedList.addAll(col1);
           myOwnLinkedList.printMyOwnLinkedList();
           System.out.println("Создадим новую коллекцию: ");
           Collection col = new ArrayList();
           col.add("Miracle");
           col.add("Friend");
           col.add("Factory");
           System.out.println(col.toString());
           System.out.println("Вставим ее на место 1: ");
           myOwnLinkedList.addAll(1, col);
           myOwnLinkedList.printMyOwnLinkedList();
           Iterator<String> iter = myOwnLinkedList.iterator();
       while (iter.hasNext())
           System.out.println(iter.next());
       } catch (OutOfBondsException ex) {
           System.out.println(ex.getMessage());
       }
       
    }   
}