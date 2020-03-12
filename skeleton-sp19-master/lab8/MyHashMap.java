import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V>{
    private Set<K> keySet;
    private int maxSize;
    private double loadFactor;
    private SequentialSearchST<K, V>[] list;
    public MyHashMap(){
        this.maxSize = 8;
        this.loadFactor = 2;
        this.list = (SequentialSearchST<K, V>[]) new SequentialSearchST[this.maxSize];
        for (int i = 0; i < this.maxSize; i++)
            this.list[i] = new SequentialSearchST<K, V>();
        this.keySet = new HashSet<K>();
    }
    public MyHashMap(int initialSize){
        this.maxSize = initialSize;
        this.loadFactor = 2;
        this.list = (SequentialSearchST<K, V>[]) new SequentialSearchST[this.maxSize];
        this.keySet = new HashSet<K>();
    }
    public MyHashMap(int initialSize, double loadFactor){
        this.maxSize = initialSize;
        this.loadFactor = loadFactor;
        this.list = (SequentialSearchST<K, V>[]) new SequentialSearchST[this.maxSize];
        this.keySet = new HashSet<K>();
    }

    private int hashCode(K key){
        return Math.floorMod(key.hashCode(), this.maxSize);
    }
    private int hashCode(K key, int x){
        return Math.floorMod(key.hashCode(), x);
    }

    @Override
    public void clear(){
        this.maxSize = 8;
        this.list = (SequentialSearchST<K, V>[]) new SequentialSearchST[this.maxSize];
        this.keySet = new HashSet<K>();
    }

    @Override
    public boolean containsKey(K key){
        return this.keySet.contains(key);
    }

    @Override
    public V get(K key){
        int code = hashCode(key);
        return this.list[code].get(key);
    }

    @Override
    public int size(){
        return this.keySet.size();
    }

    @Override
    public void put(K key, V value){
        int code = hashCode(key);
        this.list[code].put(key, value);
        this.keySet.add(key);
        if(size() > this.maxSize*this.loadFactor){ //resizing
            resize();
        }
    }

    @Override
    public Set<K> keySet(){
        return this.keySet;
    }

    @Override
    public V remove(K key){
        throw new UnsupportedOperationException("Not a supported operation!");
    }

    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException("Not a supported operation!");
    }

    @Override
    public Iterator<K> iterator(){
        return this.keySet.iterator();
    }

    private void resize(){
        SequentialSearchST<K, V>[] newList = (SequentialSearchST<K, V>[]) new SequentialSearchST[this.maxSize*2];
        for (int i = 0; i < this.maxSize*2; i++)
            newList[i] = new SequentialSearchST<K, V>();
        for(K key: this.keySet){
            int code = hashCode(key, this.maxSize*2);
            newList[code].put(key, this.get(key));
        }
        this.maxSize *= 2;
        this.list = newList;
    }
}
