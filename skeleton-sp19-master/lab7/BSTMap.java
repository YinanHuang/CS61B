//package Map61B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        private int size;
        public Node(K key, V val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }


    // clear all the subtree.
    public void clear(Node x) {
        if (x.left == null || x.right == null) {
            return;
        }
        clear(x.left);
        clear(x.right);
        x.left = null;
        x.right = null;
    }
    @Override
    public void clear(){
        clear(this.root); // clear all the nodes except for the root
        this.root = null;
    }
    // return value corresponding to key.
    private Node findKey(Node x, K key){
        if(key == null){
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        } else if (cmp > 0){
            return findKey(x.right, key);
        } else{
            return findKey(x.left, key);
        }
    }

    @Override
    public boolean containsKey(K key){
        if(findKey(this.root, key) != null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public V get(K key){
        Node node = findKey(this.root, key);
        if(node != null){
            return node.val;
        } else{
            return null;
        }
    }

    @Override
    public int size(){
        return this.size(this.root);
    }

    //enter a node of the tree and return the size of the subtree of that node
    public int size(Node x){
        if(x == null) {
            return 0;
        }
        else {
            return x.size;
        }
    }


    private Node put(Node x, K key, V value){
        if(x == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            x.val = value;
        } else if(cmp > 0){
            x.right = put(x.right, key, value);
        } else{
            x.left = put(x.left, key, value);
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    @Override
    public void put(K key, V value){
        if(key == null){
            throw new IllegalArgumentException("calls put() with a null key");
        }
        this.root = put(this.root, key, value);
    }


    private void printInOrder(Node x){
        if(x == null){
            return;
        }
        printInOrder(x.left);
        System.out.print(x.key);
        System.out.print(":");
        System.out.println(x.val);
        printInOrder(x.right);
    }

    public void printInOrder(){
        printInOrder(this.root);
    }

    @Override
    public V remove(K key){
        throw new UnsupportedOperationException("this operation is unsupported");
    }

    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException("this operation is unsupported");
    }

    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException("this operation is unsupported");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("this operation is unsupported");
    }


    /*
    private void keys(List<K> list, Node x){
        if(x == null){
            return;
        }
        keys(list, x.left);
        list.add(x.key);
        keys(list, x.right);
    }
    @Override
    public List<K> keys(){
        List<K> list = new ArrayList<K>();
        keys(list, this.root);
        return list;
    }
     */
}
