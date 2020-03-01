public class Sort{
    public static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int smallIndex = findSmallest(x,start);
        swap(x,start,smallIndex);
        sort(x,start+1);
    }
    public static void selectionSort(String[] x){
        sort(x, 0);
    }

    /** Find the smallest element from index start */
    public static int findSmallest(String[] x, int start){
        int smallIndex = start;
        for(int i=start;i<x.length;i++){
            if(x[i].compareTo(x[smallIndex]) < 0){
                smallIndex = i;
            }
        }
        return smallIndex;
    }

    public static void swap(String x[],int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }


}
