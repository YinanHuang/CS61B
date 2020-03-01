import org.junit.Test;

public class Combine {
    public static int combine(ComFunc f, int[] x){
        if(x.length == 0){
            return -1;
        }
        return combineHelper(f, x, 0);
    }

    private static int combineHelper(ComFunc f, int[] x, int start){
        // calculate from start
        if(start == x.length - 1){
            return x[start];
        }
        return f.apply(x[start], combineHelper(f, x, start+1));
    }

    @Test
    public void test(){
        int[] x = new int[]{1,2,3};
        myAdd add = new myAdd();
        System.out.print(combine(add, x));
    }
}
