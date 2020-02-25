public class Dog{
    public int weight;
    public static String name="happy";
    public Dog(int w){
        this.weight=w;
    }
    public Dog maxDog(Dog d1, Dog d2) {
    if (this.weight > d2.weight) {
        return this;
    }
    return d2;
}
}
