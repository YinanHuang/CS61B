public class test{
    public static void main(String[] args){
        LinkedListDeque<Integer> list = new LinkedListDeque<Integer>();
        list.addFirst(9);
        list.addLast(0);
        list.addLast(1);
        list.addFirst(2);
        list.removeLast();
        list.removeFirst();
        LinkedListDeque<Integer> list2 = new LinkedListDeque<Integer>(list);
        System.out.println(list2.getRecursive(0));
    }
}
