public class WordUtils {
    public static String longest(SLList<String> list) {
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            String longest = list.get(maxIndex);
            String current = list.get(i);
            if (longest.length() < current.length()) {
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }
}