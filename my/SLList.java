public class SLList{
    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }
    public SLList(int x){
        this.first = new IntNode(x,null);
    }

    public IntNode first;

    public void addFirst(int x){
    this.first = new IntNode(x,this.first);
    }

    public void insert(int x, int position){
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

    }
    /** Use a recursive method to reverse a list */
    public IntNode reverse(IntNode rest){
        if(rest == null || rest.next == null){
            return rest;
        }
        IntNode revRest = reverse(rest.next);
        rest.next.next = rest;
        rest.next = null;
        return revRest;
    }
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
    /*
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
    */
    /** Adds an item to the first node */
    /*
    public void addFirst(int x){
        this.sentinel.next = new IntNode(x, this.sentinel.next);
        this.size++;
    }
*/
    /** Return the first item */
    /*
    public int getFirst(){
        return this.sentinel.next.item;
    }
*/
    /** Add an item to the end of the list */
    /*
    public void addLast(int x) {

        SLList.IntNode p = this.sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
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
*/
    /** An example of overloaded function: two functions with the same name in
     * java is acceptable.
     */
    /*
    public int size(){
        //return this.size(this.first);
        return this.size;
    }
*/
}
