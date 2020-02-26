public interface Deque<any> {
    public void addFirst(any x);
    public any removeFirst();
    public void addLast(any x);
    public any removeLast();
    public boolean isEmpty();
    public int size();
    public any get(int i);
    //public any getR(anyNode node, int i);
    public any getRecursive(int i);

}
