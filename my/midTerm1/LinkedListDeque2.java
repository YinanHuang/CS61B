public class LinkedListDeque2<any> extends LinkedListDeque<any>{
    private LinkedListDeque<any> deletedList;

    public LinkedListDeque2(){
        super(); // call the constructor. If you do not do so, it will automatically do that.
        deletedList = new LinkedListDeque<any>();
    }
    public LinkedListDeque2(LinkedListDeque<any> other){
        super(other); // call the constructor. If you do not do so, it will automatically do that.
        deletedList = new LinkedListDeque<any>();
    }

    @Override
    public any removeLast(){
        any x = super.removeLast();
        deletedList.addLast(x);
        return x;
    }

    public void printLostItems(){
        deletedList.print();
    }
}
