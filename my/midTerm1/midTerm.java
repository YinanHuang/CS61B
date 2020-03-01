import org.junit.Test;

public class midTerm {

    public class IntList{
        public int first;
        public IntList rest;
        public IntList(int first, IntList rest){
            this.first = first;
            this.rest = rest;
        }
    }
    public static int[] sans(int[] x,int y){
        int[] xClean = new int[x.length];
        int j = 0;
        for (int i = 0;i<x.length;i++){
            if (x[i] != y){
                xClean[j] = x[i];
                j++;
            }
        }
        int[] r = new int[j];
        System.arraycopy(xClean, 0, r, 0, j);
        return r;
    }




    @Test
    public void testSans(){
        int[] x = new int[]{1,2,3,4,3};
        int y =3;
        int[] z = sans(x, y);
        for (int Z : z){
            System.out.print(Z+"");
        }
    }
}
