package hw2;

import org.junit.Test;

public class hw2Test {
    @Test
    public void test(){
        PercolationStats p = new PercolationStats(80, 200);
        System.out.println(p.mean());
    }
}
