public class WordUtils {

    public static String longest(List61B<String> list) {
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
    public static void main(String[] args){
        /*
        LinkedListDeque<String> list = new LinkedListDeque<String>();
        ArrayDeque<String> list2 = new ArrayDeque<String>();
        list.addFirst("I");
        list.addFirst("have");
        list.addFirst("an");
        list.addLast("apple");
        list2.addFirst("I");
        list2.addFirst("have");
        list2.addLast("an");
        list2.addFirst("apple");
        //System.out.println(list2.get(3));
        System.out.println(longest(list));
        //System.out.println(longest(list2));
        */
         LinkedListDeque<String>list = new LinkedListDeque<String>();
         list.addFirst("apple");
         list.print();
    }


}