public class ArrayStack<Item> implements Stack<Item> {
    private Item[] items;
    private int size;
    private static double factor = 1.5;

    public ArrayStack(){
        this.items = (Item[]) new Object[this.items.length];
        this.size = 0;
    }

    private void resize(int capacity){
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(this.items, 0, newItems, 0, this.size);
        this.items = newItems;
    }
    public void push(Item x){
        if(usageRatio() == 1){ // Stack is full
            int maxsize = (int)(this.items.length*factor);
            resize(maxsize);
        }
        this.items[this.size] = x;
        this.size++;
    }

    public Item pop(){
        if(this.size == 0){
            return null;
        }
        if(usageRatio()<0.25 && this.items.length > 8){
            int maxsize = (int)(this.items.length/factor);
            resize(maxsize);
        }
        this.size--;
        Item x = this.items[this.size];
        this.items[this.size] = null;
        return x;
    }

    public int size(){
        return this.size;
    }

    private double usageRatio(){
        return this.size/this.items.length;
    }
}
