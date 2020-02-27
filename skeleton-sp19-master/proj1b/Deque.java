public interface Deque<any> {
    public void addFirst(any x);
    public any getFirst();
    public any removeFirst();
    public void addLast(any x);
    public any getLast();
    public any removeLast();
    default public boolean isEmpty(){
        if(this.size() == 0){
            return true;
        } else{
            return false;
        }
    };
    public int size();
    public any get(int i);
    //public any getR(LinkedListDeque<any>.anyNode node, int i);
    //public any getRecursive(int i);

}
