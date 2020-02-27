public class HelloWorld {
    public static int doTwice(UnionFunc f, int x){
        return f.apply(f.apply(x));
    }
    public static void main(String[] args) {
        UnionFunc magic = new square();
        System.out.println(doTwice(magic,5));
    }
}
