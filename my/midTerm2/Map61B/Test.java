package Map61B;
import java.util.*;
import java.util.Iterator;

public class Test {
    public static void main(String[] args){
        ArraySet<Integer> set = new ArraySet<Integer>();
        set.add(1);
        set.add(2);
        Iterator<Integer> it = set.iterator();
        System.out.println(set.toString());
        ArrayList<Integer> list;
    }
    public static boolean twoSum(int[] A, int x){
        int left = 0;
        int right = A.length;
        while(left != right){
            if(A[left] + A[right] == x){
                return true;
            } else if(A[left] + A[right] < x){
                left++;
            } else{
                right--;
            }
        }
        return false;
    }
}
