import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars(){
        assertTrue(offByOne.equalChars('a','b'));
        assertFalse(offByOne.equalChars('A','c'));
        assertFalse(offByOne.equalChars('b','A'));
    }

} //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.