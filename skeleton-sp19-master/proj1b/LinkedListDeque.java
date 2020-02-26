public class LinkedListDeque<any> implements Deque<any>{
    /** anyNode is a node in list with item/next; */
    public class anyNode {
        public any item;
        public anyNode prev;
        public anyNode next;
        public anyNode(any item, anyNode prev, anyNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /** List with head (invariant) and size */
    private anyNode head;
    //private anyNode tail;
    private int size;
    public LinkedListDeque(){
        this.head = new anyNode(null,null, null);
        this.head.prev = this.head;
        this.head.next = this.head;
        this.size = 0;
    }
    public LinkedListDeque(LinkedListDeque other){
        anyNode copy = other.head;
        anyNode paste = new anyNode(null,null,null);
        this.head = paste;
        while(copy.next != other.head){
            copy = copy.next;
            paste.next = new anyNode(copy.item,paste,null);
            paste = paste.next;
        }
        paste.next = this.head;
        this.head.prev = paste;
    }

    @Override
    public void addFirst(any x){
        this.size++;
        anyNode node = new anyNode(x, this.head, this.head.next);
        this.head.next = node;
        node.next.prev = node;
    }

    @Override
    public any removeFirst(){
        anyNode node = this.head.next;
        any x = node.item;
        node.next.prev = this.head;
        this.head.next = node.next;
        if(x != null){
            this.size--;
        }
        return x;
    }

    @Override
    public void addLast(any x){
        this.size++;
        anyNode node = new anyNode(x, this.head.prev, this.head);
        node.prev.next = node;
        this.head.prev = node;
    }

    @Override
    public any removeLast() {
        anyNode node = this.head.prev;
        any x = node.item;
        this.head.prev = node.prev;
        node.prev.next = this.head;
        if(x != null){
            this.size--;
        }
        return x;
    }

    @Override
    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int size(){
        return this.size;
    }

    public void printDeque(){
        for(anyNode p = this.head.next;p != this.head;p = p.next){
            System.out.print(p.item+" ");
        }
        System.out.println();
    }

    @Override
    public any get(int i){
        int j = 0;
        anyNode p = this.head.next;
        while(p.next != this.head && j<i){
            p = p.next;
            j++;
        }
        return p.item;
    }

    public any getR(anyNode rest, int i){
        if(i==0 || rest.next == this.head){
            return rest.item;
        }
        return getR(rest.next, i-1);
    }

    public any getRecursive(int i){
        return getR(this.head.next, i);
    }

}
