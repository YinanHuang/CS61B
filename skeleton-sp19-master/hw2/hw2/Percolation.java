package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private WeightedQuickUnionUF model;
    private int[][] square;
    public Percolation(int N){
        this.N = N;
        square = new int[N][N];
        this.model = new WeightedQuickUnionUF(N*N+2);
        for(int i = 0; i < this.N; i++){
            model.union(xyTo1D(0, i), N*N); //dummy top node
            model.union(xyTo1D(N-1, i), N*N+1); // dummy bottom node
        }
    }               // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col){
        if(row >= this.N || col >= this.N || row < 0 || col < 0){
            throw new java.lang.IndexOutOfBoundsException();
        }
        this.square[row][col] = 1;
        if(isOpen(row+1, col)) model.union(xyTo1D(row, col), xyTo1D(row+1, col));
        if(isOpen(row, col+1)) model.union(xyTo1D(row, col), xyTo1D(row, col+1));
        if(isOpen(row-1, col)) model.union(xyTo1D(row, col), xyTo1D(row-1, col));
        if(isOpen(row, col-1)) model.union(xyTo1D(row, col), xyTo1D(row, col-1));
    };       // open the site (row, col) if it is not open already

    public boolean isOpen(int row, int col){
        if(row >= this.N || col >= this.N || row < 0 || col < 0){
            return false;
        }
        if(this.square[row][col] == 1){
            return true;
        } else{
            return false;
        }
    };  // is the site (row, col) open?

    public boolean isFull(int row, int col){
        if(row > this.N || col > this.N || row < 0 || col < 0){
            throw new java.lang.IndexOutOfBoundsException();
        }
        return model.connected(xyTo1D(row, col), N*N);
    };  // is the site (row, col) full?

    private int xyTo1D(int x, int y){
        return x * this.N + y;
    }
    public int numberOfOpenSites(){
        int sum = 0;
        for(int i = 0; i < this.N; i++){
            for(int j = 0; j < this.N; j++){
                sum += this.square[i][j];
            }
        }
        return sum;
    }           // number of open sites
    public boolean percolates(){
        return model.connected(N*N, N*N + 1);
    }              // does the system percolate?

    public static void main(String[] args) {
        Percolation model = new Percolation(5);
        PercolationVisualizer.draw(model, 5);
        model.open(0,3);
        PercolationVisualizer.draw(model, 5);
        model.open(1,3);
        PercolationVisualizer.draw(model, 5);
        model.open(1,4);
        PercolationVisualizer.draw(model, 5);
        model.open(2,4);
        PercolationVisualizer.draw(model, 5);
        model.open(3,4);
        PercolationVisualizer.draw(model, 5);
        model.open(4,4);
        PercolationVisualizer.draw(model, 5);
        System.out.print(model.percolates());
    }

}
