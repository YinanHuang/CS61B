public interface ListOfInts {
    void addLast(int x);
    int get(int i);
    int size();
    void set(int i, int x);
    default public void plusEquals(ListOfInts list){
        if(list == null || list.size() != this.size()){ return; }
        for(int i = 0;i<this.size();i++){
            int temp = this.get(i) + list.get(i);
            this.set(i, temp);
        }
    };
}
