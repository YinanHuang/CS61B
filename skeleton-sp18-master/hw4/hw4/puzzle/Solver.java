package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solver {
    private Node finalNode;
    public Solver(WorldState initial){
        PriorityQueue<Node> moveSequence = new PriorityQueue<Node>(8, new myComparator());
        Node initialNode = new Node(initial, 0, null);
        Node X = initialNode;
        while(!X.currentState.isGoal()){
            for(WorldState N : X.currentState.neighbors()){
                Node node = new Node(N, X.numMove + 1, X);
                if(node.equals(X.prev)){
                    continue;
                }
                moveSequence.add(node);
            }
            X = moveSequence.poll();
        }
        this.finalNode = X;
    }
    public int moves(){
        return this.finalNode.numMove;
    }
    public Iterable<WorldState> solution(){
        ArrayList<WorldState> list = new ArrayList<WorldState>();
        Node X = this.finalNode;
        while(X != null){
            list.add(0, X.currentState);
            X = X.prev;
        }
        return list;
    }

    private class Node{
        public WorldState currentState;
        public int numMove;
        public Node prev;
        public int distance;
        public Node(WorldState currentState, int numMove, Node prevNode){
            this.currentState = currentState;
            this.numMove = numMove;
            this.prev = prevNode;
            this.distance = this.currentState.estimatedDistanceToGoal();
        }
        @Override
        public boolean equals(Object o){
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.currentState.equals(((Node) o).currentState);
        }
    }

    private class myComparator implements Comparator<Node>{
        @Override
        public int compare(Node n1, Node n2){
            int x1 = n1.numMove + n1.distance;
            int x2 = n2.numMove + n2.distance;
            if(x1 > x2) return 1;
            if(x1 < x2){
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object o){
            return this.equals(o);
        }
    }
}
