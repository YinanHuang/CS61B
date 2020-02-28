import java.util.Comparator;
public class Cat extends Animal implements Comparable<Cat>{
    public Cat(String name, int age){
        super(name, age);
        this.noise = "Meow!";
    }


    /** Make a name-comparator */
    private static class nameComparator implements Comparator<Cat>{
        @Override
        public int compare(Cat a, Cat b){
            return a.name.compareTo(b.name);
        }
    }
    public static Comparator<Cat> getNameComparator(){
        return new nameComparator();
    }


    @Override
    public int compareTo(Cat o){
        return this.age - o.age;
    }

    @Override
    public void greet(){
        System.out.println("Cat " + name + " says: " + makeNoise());
        //System.out.println(this.age);
        //System.out.println(super.age);
    }

    public static void main (String[] args) {
        Object o2 = new Cat("hyn",10);
        Cat sdx = ((Cat) o2);
        sdx.greet();

        Animal dx = ((Animal) o2);
        dx.greet();
    }
}
