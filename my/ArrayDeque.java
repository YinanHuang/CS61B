public class ArrayDeque<any> {
    public any[] items;
    public int size;
    public double factor;
    public int maxsize;

    public ArrayDeque(){
        this.maxsize = 8;
        this.items = (any[])new Object[this.maxsize];
        this.factor = 1.3;
        this.size = 0;
    }
    public void addLast(any x){
        if(this.size == this.maxsize){
            this.maxsize *= this.factor;
            any[] newItems = (any[])new Object[this.maxsize];
            System.arraycopy(this.items, 0, newItems, 0, this.size);
            newItems[this.size] = x;
            this.items = newItems;
        } else {
            this.items[this.size] = x;
        }
        this.size++;
    }

    public any getLast(){
        return this.items[this.size-1];
    }
    public any removeLast(){
        any x= this.getLast();
        this.size--;
        return x;
    }

}
