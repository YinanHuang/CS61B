import org.junit.Test;
import static org.junit.Assert.*;
public class testArrayDeque {
    @Test
    public void TestAddLast(){
        ArrayDeque<Integer> array = new ArrayDeque<Integer>();
        array.addLast(5);
        array.addLast(10);
        int actual = array.getLast();
        assertEquals(10,actual);
        assertEquals(array.nextLast,2);
        //System.out.println(array.nextLast);
    }

    @Test
    public void IntegrationTest(){
        ArrayDeque<Integer> array = new ArrayDeque<Integer>();
        array.addLast(0);
        array.addLast(1);
        array.addFirst(2);
        array.addLast(3);
        array.addFirst(4);
        array.addFirst(5);
        array.addLast(6);
        array.removeFirst();
        array.removeLast();
        array.removeLast();
        int actualFirst = array.getFirst();
        int actualLast = array.getLast();
        assertEquals(4,actualFirst);
        assertEquals(1,actualLast);
    }
}
