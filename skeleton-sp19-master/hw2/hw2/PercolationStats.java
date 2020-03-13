package hw2;

import java.util.Random;

public class PercolationStats {
    private Percolation model;
    private int[] threshold;
    public PercolationStats(int N, int T){
        threshold = new int[T];
        for(int i = 0; i < T; i++){
            int count = 0;
            this.model = new Percolation(N);
            //System.out.println("round:"+i);
            while(!this.model.percolates()){
                Random random=new Random();//以系统当前时间作为随机数生成的种子
                int x = random.nextInt(N);
                int y = random.nextInt(N);
                while(this.model.isOpen(x, y)){
                    random=new Random();//以系统当前时间作为随机数生成的种子
                    x = random.nextInt(N);
                    y = random.nextInt(N);
                }
                this.model.open(x, y);
                //PercolationVisualizer.draw(model, N);
                count++;

            }
            //System.out.println(count);
            this.threshold[i] = count;
        }

    }   // perform T independent experiments on an N-by-N grid
    public double mean(){
        double ans = 0;
        for (int i = 0; i < this.threshold.length; i++){
            ans += this.threshold[i];
        }
        return ans/this.threshold.length;
    }           // sample mean of percolation threshold
    //public double stddev()                  // sample standard deviation of percolation threshold
    //public double confidenceLow()           // low  endpoint of 95% confidence interval
    //public double confidenceHigh()          // high endpoint of 95% confidence interval
}
