public class SLList{
    /** Inner class: IntNode */
    public class IntNode{
        public int item;
        //public IntNode prev;
        public IntNode next;
        public IntNode(int i, IntNode n){
            this.item=i;
            this.next=n;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;
    public SLList(int x){
        this.sentinel = new IntNode(0,new IntNode(x,null));
        this.last = this.sentinel.next;
        this.size=1;
    }
    public SLList(){
        this.sentinel = new IntNode(0,null);
        this.last = this.sentinel;
        this.size=0;
    }
    /** Adds an item to the first node */
    public void addFirst(int x){
        this.sentinel.next = new IntNode(x, this.sentinel.next);
        this.size++;
    }

    /** Return the first item */
    public int getFirst(){
        return this.sentinel.next.item;
    }

    /** Add an item to the end of the list */
    public void addLast(int x) {
        /*
        SLList.IntNode p = this.sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        */
        this.last.next = new IntNode(x,null);
        this.last=this.last.next;
        this.size++;
    }
    public int getLast(){
        return this.last.item;
    }

    public int size(SLList.IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1+size(p.next);
    }

    /** An example of overloaded function: two functions with the same name in
     * java is acceptable.
     */
    public int size(){
        //return this.size(this.first);
        return this.size;
    }
}
