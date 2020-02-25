public class HelloWorld {
    public static void main(String[] args) {
        SLList list = new SLList(5);
        list.addFirst(10);
        list.insert(15,2);
        list.first = list.reverse(list.first);
        for(SLList.IntNode p = list.first; p != null;p=p.next){
            System.out.println(p.item);
        }
    }
}
