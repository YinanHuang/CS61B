package Map61B;

import java.util.HashMap;

public class Fibonacci {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int fib(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        } else if(map.containsKey(n)){
            return map.get(n);
        }
        int result = fib(n-1) + fib(n-2);
        map.put(n, result);
        return result;
    }

    public static int fib2(int n){
        if(n == 0){
            return 0;
        } else if(n == 1){
            return 1;
        }
        return fib2(n-1) + fib2(n - 2);
    }
}
