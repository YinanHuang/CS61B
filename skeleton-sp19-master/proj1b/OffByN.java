public class OffByN implements CharacterComparator{
    private int N;
    public OffByN(int n){
        this.N = n;
    }
    public boolean equalChars(char x, char y){
        return Math.abs(x-y) == N;
    }
}
