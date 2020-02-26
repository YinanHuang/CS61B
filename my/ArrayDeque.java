public class ArrayDeque<any> implements  List61B<any> {
    public any[] items;
    public int size;
    public double factor;
    public int maxsize;
    public int nextFirst;
    public int nextLast;

    public ArrayDeque(){
        this.maxsize = 8;
        this.items = (any[])new Object[this.maxsize];
        this.factor = 1.3;
        this.size = 0;
        this.nextFirst = 0;
        this.nextLast = 0;
    }

    /** Add x to the end of the list */
    public void addLast(any x){
        if(this.size == this.maxsize){
            return;
        } else{
            this.items[this.nextLast] = x;
            this.nextLast = (this.nextLast+1) % this.maxsize;
            if(this.size == 0){
                this.nextFirst = (this.nextFirst - 1 + this.maxsize) % this.maxsize;
            }
            this.size++;
        }

    }

    /** Add x to the head of the list */
    public void addFirst(any x){
        if(this.size == this.maxsize){
            return;
        } else {
            this.items[this.nextFirst] = x;
            this.nextFirst = (this.nextFirst - 1 + this.maxsize) % this.maxsize;
            if(this.size == 0){
                this.nextLast = (this.nextLast+1) % this.maxsize;
            }
            this.size++;
        }
    }

    /** Get the last item of the list */
    public any getLast(){
        if(this.nextLast == this.nextFirst){ // the list is empty
            return null;
        }
        return this.items[(this.nextLast - 1 + this.maxsize) % this.maxsize];
    }

    /** Get the head item of the list */
    public any getFirst(){
        if(this.nextLast == this.nextFirst){ // the list is empty
            return null;
        }
        return this.items[(this.nextFirst + 1) % this.maxsize];
    }

    /** Remove the last item of the list */
    public any removeLast(){
        any x = this.getLast();
        if(x == null){
            return null;
        }
        this.size--;
        this.nextLast = (this.nextLast - 1 + this.maxsize) % this.maxsize;
        return x;
    }

    /** Remove the first item of the list */
    public any removeFirst(){
        any x = this.getFirst();
        if(x == null){
            return null;
        }
        this.size--;
        this.nextFirst = (this.nextFirst + 1) % this.maxsize;
        return x;
    }

    /** Get the i th item in the list */
    public any get(int i){
        if(i >= this.maxsize){
            return this.items[(this.nextLast - 1 + this.maxsize) % this.maxsize];
        }
        return this.items[(this.nextFirst + i + 1) % this.maxsize];
    }

    /** Insert x at position */
    public void insert(any x, int position){
        if(this.size == this.maxsize){
            return;
        } else{
            any[] newItems = (any[]) new Object();
            int i, pin;
            for(i = 0;i<position;i++){
                pin = (this.nextFirst + i + 1) % this.maxsize;
                newItems[pin] = this.items[pin];
            }
            pin = (this.nextFirst + position + 1) % this.maxsize;
            newItems[pin] = x;
            for(i = position;i<this.size;i++){
                pin = (this.nextFirst + i + 1) % this.maxsize;
                newItems[pin+1] = this.items[pin];
            }
            this.items = newItems;
            if(position == 0){
                this.nextFirst = (this.nextFirst - 1 + this.maxsize) % this.maxsize;
            } else{
                this.nextLast = (this.nextLast + 1) % this.maxsize;
            }
        }
    }

    public int size(){
        return this.size;
    }

}
