package hw4.puzzle;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Board implements WorldState{
    private int[][] board;
    final private int BLANK = 0;
    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }
    public Board(int[][] tiles){
        this.board = new int[tiles.length][tiles.length];
        for(int i = 0;i < tiles.length; i++){
            for(int j = 0; j < tiles.length; j++){
                this.board[i][j] = tiles[i][j];
            }
        }
    }
    public int tileAt(int i, int j){
        return this.board[i][j];
    }
    public int size(){
        return board.length;
    }
    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }
    public int hamming(){
        return 0;
    }
    public int manhattan(){
        PriorityQueue<Integer> list = new PriorityQueue<Integer>();
        HashMap<Integer, Integer> table= new HashMap<Integer, Integer>();
        int distance = 0;
        for(int i = 0;i < this.size(); i++){
            for(int j = 0; j < this.size(); j++){
                if(this.board[i][j] != BLANK){
                    list.add(this.board[i][j]);
                }
            }
        }
        for(int i = 0; i < this.size(); i++){
            for(int j = 0; j < this.size(); j++){
                if(list.peek() != null) {
                    table.put(list.poll(), i * this.size() + j);
                }
            }
        }
        for(int i = 0; i < this.size(); i++){
            for(int j = 0; j < this.size(); j++){
                if(!table.containsKey(this.board[i][j])){
                    continue;
                }
                int pos = table.get(this.board[i][j]);
                int dy = Math.abs(pos % this.size() - j);
                int dx = Math.abs(pos / this.size() - i);
                distance += dx + dy;
            }
        }
        return distance;
    }
    public int estimatedDistanceToGoal(){
        return manhattan();
    }
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        for(int i = 0; i < this.size(); i++){
            for(int j = 0; j < this.size(); j++){
                if(this.board[i][j] != ((Board) o).board[i][j]) return false;
            }
        }
        return true;
    }

}
