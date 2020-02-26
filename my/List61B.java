public interface List61B<any>{
    public void addFirst(any x);
    public void addLast(any y);
    public any getFirst();
    public any getLast();
    public any removeFirst();
    public any removeLast();
    public any get(int index);
    public void insert(any x, int position);
    public int size();
    default public void print(){
        System.out.println(get(0));
    }
}
