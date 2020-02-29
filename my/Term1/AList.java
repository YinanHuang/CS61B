/** Array based list.
 *  @author Josh Hug
 */

public class AList{
    /** Creates an empty list. */
    private int[] items;
    private int size;
    private int maxsize;

    /** Instantiation process */
    public AList() {
        this.maxsize = 100;
        this.items = new int[this.maxsize];
        this.size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(this.size==this.maxsize){
            int[] a = new int[++this.maxsize];
            System.arraycopy(this.items, 0, a, 0, this.size);
            a[size] = x;
            this.items = a;
        } else{
            this.items[this.size] = x;
        }
        size++;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return this.items[this.size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return this.items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return this.size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = this.getLast();
        size--;
        return x;
    }

    public static int[] insert(int x[], int item, int position){
        position = Math.min(position,x.length);
        int[] xNew = new int[x.length+1];
        for(int i=0;i<position;i++){
            xNew[i] = x[i];
        }
        xNew[position] = item;
        for(int i=position;i<x.length;i++){
            xNew[i+1] = x[i];
        }
        return xNew;
    }
    public static void reverse(int[] x){
        for(int i=0;i<x.length;i++){
            int temp = x[i];
            int j = x.length-i-1;
            x[i] = x[j];
            x[j] = temp;
        }
    }

    public static int[] xify(int[] x){
        int  total=0;
        for(int item:x){
            total+=item;
        }
        int[] xNew = new int[total];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<x[i];j++){
                xNew[j] = x[i];
            }
        }
        return xNew;
    }


}
