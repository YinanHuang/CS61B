public class SequentialSearchST<K, V>{
    private Node first;
    private class Node{
        private K key;
        private V val;
        private Node next;
        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public V get(K key){
        for(Node x = this.first; x != null; x = x.next){
            if(x.key.equals(key)){
                return x.val;
            }
        }
        return null;
    }

    public void put(K key, V val){
        for(Node x = this.first; x != null; x = x.next){
            if(x.key.equals(key)){
                x.val = val;
            }
        }
        this.first = new Node(key, val, this.first);
    }

}
