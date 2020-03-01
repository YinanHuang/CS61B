public class DLListOfInts implements ListOfInts {
    private class IntNode{
        public int item;
        public IntNode next, prev;
        public IntNode(int item, IntNode next, IntNode prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private IntNode sentinel;
    private int size;
    public DLListOfInts(){
        IntNode head = new IntNode(-1, null, null);
        this.sentinel = head;
        head.next = head;
        head.prev = head;
        this.size = 0;
    }
    public void addLast(int x){
        IntNode tail = new IntNode(x, this.sentinel, this.sentinel.prev);
        this.sentinel.prev = tail;
        tail.prev.next = tail;
        this.size++;
    }
    public int get(int i){
        IntNode p = this.sentinel.next;
        i = Math.min(i, this.size);
        for(int j = 0;j < i;j++){
            p = p.next;
        }
        return p.item;
    }
    public int size(){
        return this.size;
    }
    public void set(int i, int x){
        IntNode p = this.sentinel.next;
        i = Math.min(i, this.size);
        for(int j = 0;j < i;j++){
            p = p.next;
        }
        p.item = x;
    }

    @Override
    public void plusEquals(ListOfInts list){
        if(list == null || list.size() != this.size()){
            return;
        }
        IntNode p1, p2;
        for(p1 = this.sentinel.next;p1 != this.sentinel;p1 = p1.next, p2 = p2.next){
            p1.item += p2.item;
        }
    }
}
