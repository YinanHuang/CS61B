import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        //Deque<Character> d1 = palindrome.wordToDeque("cat");
        boolean actual1 = Palindrome.isPalindrome("cat");
        boolean actual2 = Palindrome.isPalindrome("raceCar");
        boolean actual3 = Palindrome.isPalindrome("racecar");
        assertFalse(actual1);
        assertFalse(actual2);
        assertTrue(actual3);
    }

    @Test
    public void testIsPalindrome2(){
        //Deque<Character> d1 = palindrome.wordToDeque("cat");
        CharacterComparator cc = new OffByOne();
        boolean actual1 = Palindrome.isPalindrome("cat",cc);
        boolean actual2 = Palindrome.isPalindrome("racecar",cc);
        boolean actual3 = Palindrome.isPalindrome("flake",cc);
        assertFalse(actual1);
        assertFalse(actual2);
        assertTrue(actual3);
    }

}    // Uncomment this class once you've created your Palindrome class.