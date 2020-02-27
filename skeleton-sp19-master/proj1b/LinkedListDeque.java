public class LinkedListDeque<any> implements Deque<any>{
    /** Create a cycling double list. */

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

    /** Instantiate I */
    public LinkedListDeque(){
        this.head = new anyNode(null,null, null);
        this.head.prev = this.head;
        this.head.next = this.head;
        this.size = 0;
    }

    /** Instantiate II */
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

    /** Add a node after the head */
    @Override
    public void addFirst(any x){
        this.size++;
        anyNode node = new anyNode(x, this.head, this.head.next);
        this.head.next = node;
        node.next.prev = node;
    }

    /** Remove the node after the head */
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

    /** Get the first item */
    @Override
    public any getFirst(){
        return this.head.next.item;
    }

    /** Add a node before the head (after the last). */
    @Override
    public void addLast(any x){
        this.size++;
        anyNode node = new anyNode(x, this.head.prev, this.head);
        node.prev.next = node;
        this.head.prev = node;
    }

    /** Remove a node before the head (after the last). */
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

    /** Get the last item */
    @Override
    public any getLast(){
        return this.head.prev.item;
    }

    /** Return the size of the list. */
    @Override
    public int size(){
        return this.size;
    }

    /** Print the whole list. */
    public void printDeque(){
        for(anyNode p = this.head.next;p != this.head;p = p.next){
            System.out.print(p.item+" ");
        }
        System.out.println();
    }

    /** Get the i th item of our list. */
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

    /** Get the i th item in our list by using a recursive method. */

    public any getR(anyNode rest, int i){
        if(i==0 || rest.next == this.head){
            return rest.item;
        }
        return getR(rest.next, i-1);
    }

    public any getRecursive(int i){
        return getR(this.head.next, i);
    }

    /** Insert a num at position i */

    public void insert(any x, int position){
        position = Math.min(position, this.size);
        anyNode pin = this.head;
        for(int i = 0;i < position;i++){
            pin = pin.next;
        }
        anyNode node = new anyNode(x, pin, pin.next);
        pin.next = node;
        node.next.prev = node;
    }

}
