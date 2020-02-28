import java.util.*;

public class HelloWorld {
    public static int doTwice(UnionFunc f, int x){
        return f.apply(f.apply(x));
    }

    public static List<String> getWords(String inputFileName){
        List<String> words = new ArrayList<String>();
        In in = new In();
        while(!in.isEmpty()){
            words.add(in.readString());
        }
        return words;
    }

    public static int countUniqueWords(List<String> words){
        Set<String> set = new HashSet<String>(words);
        return set.size();
    }

    public static Map<String, Integer> collectWordCount(List<String> targets, List<String> words) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String t : targets) {
            counts.put(t, 0);
        }
        for (String w : words) {
            if (counts.containsKey(w)) {
                counts.put(w, counts.get(w) + 1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        Dog d = new BigDog(10,10);
        BigCoolDog bcd = new BigCoolDog(10,10,10);
        bcd =  (BigCoolDog) d;

    }

}
