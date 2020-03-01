package Map61B;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.*;

public class MapHelper {
    public static <K, V> V get(Map61B map, K key){
        return (V) map.get(key);
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B map){
        List<K> keyList = map.keys();
        if(map.size() == 0){
            return null;
        }
        K largest = keyList.get(0);
        for(K k : keyList){
            if(k.compareTo(largest) > 0){
                largest = k;
            }
        }
        return largest;
    }
    @Test
    public void testGet(){
        Map61B<String, Integer> map = new ArrayMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        org.junit.Assert.assertEquals((Integer) 2, MapHelper.get(map, "B"));
    }

    @Test
    public void testMaxKey(){
        Map61B<String, Integer> map = new ArrayMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        org.junit.Assert.assertEquals("C", MapHelper.maxKey(map));
    }

    @Test
    public void testIteration(){

    }
}
