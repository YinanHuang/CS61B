public class Palindrome{
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> list = new LinkedListDeque<Character>();
        for(int i = 0;i<word.length();i++){
            list.addLast(word.charAt(i));
        }
        return list;
    }
    public static boolean isPalindrome(String word){
        if(word.length() == 0 || word.length() == 1){
            return true;
        }
        Deque<Character> list = wordToDeque(word);
        return isPalindrome(list);

    }

    private static boolean isPalindrome(Deque<Character> list){
        if(list.size() == 1){
            return true;
        } else if(list.size() == 2) {
            return list.getFirst() == list.getLast();
        } else if(list.getFirst() != list.getLast()) {
            return false;
        } else{
            list.removeFirst();
            list.removeLast();
            return isPalindrome(list);
        }
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() == 0 || word.length() == 1){
            return true;
        }
        Deque<Character> list = wordToDeque(word);
        return isPalindrome(list,cc);
    }

    public static boolean isPalindrome(Deque<Character> list, CharacterComparator cc){
        if(list.size() == 1){
            return true;
        } else if(list.size() == 2) {
            return cc.equalChars(list.getFirst(),list.getLast());
        } else if(!cc.equalChars(list.getFirst(),list.getLast())) {
            return false;
        } else{
            list.removeFirst();
            list.removeLast();
            return isPalindrome(list,cc);
        }
    }

}
