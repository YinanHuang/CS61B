package Map61B;
import org.junit.Test;

import java.io.IOException;
import java.util.*;


public class ArrayMap<K,V> implements Map61B<K,V>{
    private K[] Keys;
    private V[] Values;
    private int size;
    public ArrayMap(){
        this.Keys = (K[]) new Object[100];
        this.Values = (V[]) new Object[100];
        this.size = 0;
    }

    public int keyIndex(K key){
        for(int i = 0;i < this.size;i++){
                if(this.Keys[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean containsKey(K key){
        int index = keyIndex(key);
        return index > -1;
    }

    @Override
    public V get(K key){
        int index = keyIndex(key);
        if(index < 0){
            throw new IllegalArgumentException("The key provided " + key + "does not exist.");
        }
        return this.Values[index];
    }

    @Override
    public void put(K key, V value){
        int index = keyIndex(key);
        if(index == -1){
            this.Keys[this.size] = key;
            this.Values[this.size] = value;
            this.size++;
        } else {
            this.Values[index] = value;
        }
    }

    @Override
    public List<K> keys(){
        List<K> keyList = new ArrayList<K>();
        for(int i = 0;i < this.size;i++){
            keyList.add(this.Keys[i]);
        }
        return keyList;

    }

    @Override
    public int size(){
        return this.size;
    }

    public Iterator<K> iterator(){
        return new ArrayMapIterator();
    }

    private class ArrayMapIterator implements Iterator<K> {
        private int wizPos;

        public ArrayMapIterator() {
            this.wizPos = 0;
        }

        public boolean hasNext() {
            return this.wizPos < size;
        }

        public K next() {
            K returnItem = Keys[this.wizPos];
            this.wizPos += 1;
            return returnItem;
        }
    }







}
