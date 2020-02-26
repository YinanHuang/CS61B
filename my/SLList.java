public class SLList<any> {
    /*
    public class IntNode{
        public any item;
        public IntNode next;
        public IntNode(any item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }
    public SLList(any x){
        this.first = new IntNode(x,null);
        this.size = 1;
    }

    public IntNode first;
    public int size;

    public void addFirst(any x){
        this.first = new IntNode(x,this.first);
        this.size++;
    }

    public any get(int j){
        IntNode p = this.first;
        for(int i = 0;i < j;i++){
            p = p.next;
        }
        return p.item;
    }

    public void insert(any x, int position){
        if(this.first == null || position==0){
            this.addFirst(x);
            return;
        }
        IntNode p = this.first;
        int i=0;
        while(i<position-1 && p.next != null){
            p=p.next;
            i++;
        }
        IntNode temp = new IntNode(x,p.next);
        p.next = temp;
        this.size++;

    }*/
    /** Use a recursive method to reverse a list */
    /*
    public IntNode reverse(IntNode rest){
        if(rest == null || rest.next == null){
            return rest;
        }
        IntNode revRest = reverse(rest.next);
        rest.next.next = rest;
        rest.next = null;
        return revRest;
    }
*/
/*
    public void reverse(){
        if(this.first == null || this.first.next == null){
            return;
        }
        IntNode front = null;
        IntNode mid = this.first;
        while(mid != null){
        IntNode end = mid.next;
        mid.next = front;
        front = mid;
        mid = end;
        }
        this.first = front;
    }
*/
    /** Inner class: IntNode */

    public class IntNode{
        public any item;
        //public IntNode prev;
        public IntNode next;
        public IntNode(any i, IntNode n){
            this.item=i;
            this.next=n;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;
    public SLList(any x){
        this.sentinel = new IntNode(null,new IntNode(x,null));
        this.last = this.sentinel.next;
        this.size = 1;
    }
    public SLList(){
        this.sentinel = new IntNode(null,null);
        this.last = this.sentinel;
        this.size = 0;
    }

    /** Adds an item to the first node */

    public void addFirst(any x){
        this.sentinel.next = new IntNode(x, this.sentinel.next);
        this.size++;
    }

    public any removeFirst(){
        return null;
    }
    /** Return the first item */

    public any getFirst(){
        return this.sentinel.next.item;
    }

    /** Add an item to the end of the list */

    public void addLast(any x) {

        SLList.IntNode p = this.sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        this.last.next = new IntNode(x,null);
        this.last=this.last.next;
        this.size++;
    }
    public any getLast(){
        return this.last.item;
    }

    /** An example of overloaded function: two functions with the same name in
     * java is acceptable.
     */
    public int size(){
        return this.size;
    }


}
