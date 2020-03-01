package Map61B;

import org.junit.Test;

import java.util.Iterator;

public class ArraySet<T extends Comparable> implements Iterable<T> {

    private T[] items;
    private int size;

    public ArraySet() {
        this.items = (T[]) new Comparable[100];
        this.size = 0;
    }

    public boolean contains(T x) {
        for (int i = 0; i < this.size; i++) {
            if (items[i].compareTo(x) == 0) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (contains(x)) {
            return;
        }
        this.items[this.size] = x;
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public Iterator<T> iterator() {
        return new ArrayMapIterator();
    }

    private class ArrayMapIterator implements Iterator<T> {
        private int wizPos;

        public ArrayMapIterator() {
            this.wizPos = 0;
        }

        public boolean hasNext() {
            return this.wizPos < size;
        }

        public T next() {
            T returnItem = items[this.wizPos];
            this.wizPos += 1;
            return returnItem;
        }
    }

    @Test
    public void main(){
        ArraySet<Integer> set = new ArraySet<Integer>();
        set.add(1);
        set.add(2);
        for(int s : set){
            System.out.println(s);
        }
        
    }

}
