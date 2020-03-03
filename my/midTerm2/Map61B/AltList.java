package Map61B;

public class AltList<X, Y> {
    private X item;
    private AltList<Y, X> next;
    public AltList(X item, AltList<Y, X> next){
        this.item = item;
        this.next = next;
    }
    public AltList<Y, X> pairsSwapped(){
        AltList<Y, X> ret = new AltList<Y, X>(this.next.item, new AltList<X, Y>(this.item, null));
        if(this.next.next != null){
            ret.next.next = this.next.next.pairsSwapped();
        }
        return ret;

    }
}
