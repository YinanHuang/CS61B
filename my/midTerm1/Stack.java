public interface Stack<Item> {
    void push(Item x);
    Item pop();
    int size();
    default void purge(Item x){
        // delete all item == x in stack
        Stack<Item> temp = new ArrayStack<Item>();
        int totalSize = this.size();
        for(int i = 0;i < totalSize;i++){
            Item y = this.pop();
            if(!y.equals(x)){
                temp.push(y);
            }
        }
        int afterSize = temp.size();
        for(int i = 0;i < afterSize;i++){
            Item y = temp.pop();
            this.push(y);
        }
    }
}
