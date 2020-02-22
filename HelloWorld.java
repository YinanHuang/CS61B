public class HelloWorld {
    public static int fib(int n,int k,int f0,int f1){
        if(n==k){
            return f0;
        }else{
            return fib(n,k+1,f1,f0+f1);
        }
    }
    public static void main(String[] args) {
        Dog[] dogs=new Dog[3];
        dogs[0]=new Dog(5);
        dogs[1]=new Dog(25);
        dogs[2]=Dog.maxDog(dogs[0],dogs[1]);
        System.out.println(dogs[2].weight);
    }
}
