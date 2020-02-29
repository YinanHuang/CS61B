import java.util.Comparator;

public class Maximizer {
    public static Comparable max(Comparable[] items, Comparator ct){
        int maxIndex = 0;
        for(int i = 0;i<items.length;i++){
            if(ct.compare(items[maxIndex], items[i]) < 0){
                maxIndex = i;
            }
        }
        return items[maxIndex];
    }

    public static void main(String[] args){
        Cat[] cats = new Cat[]{new Cat("C", 5), new Cat("B",10),
                new Cat("A",15)};
        Comparator<Cat> nameComparator = Cat.getNameComparator();
        Cat cat = (Cat) Maximizer.max(cats, nameComparator);
        System.out.println(cat.name);
    }
}
