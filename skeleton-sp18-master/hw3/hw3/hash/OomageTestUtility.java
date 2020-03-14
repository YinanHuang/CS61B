package hw3.hash;

import java.util.List;
import java.util.Random;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int[] list = new int[M];
        int N = 10000;
        for(int i = 0; i < M; i++){
            list[i] = 0;
        }
        Random random = new Random();
        for(int i = 0; i < N; i++){
            int red = random.nextInt(45)*5;
            int blue = random.nextInt(45)*5;
            int green = random.nextInt(45)*5;
            SimpleOomage ooA = new SimpleOomage(red, green, blue);
            int code = (ooA.hashCode() & 0x7FFFFFFF) % M;
            list[code]++;
        }
        for(int i = 0; i < M; i++){
            if(list[i] < N/50 || list[i] > N/2.5){
                return false;
            }
        }
        return true;
    }
}
