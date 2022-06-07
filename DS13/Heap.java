package DS13;

public class Heap {
    public static void sort(Comparable[] a) {
        int heapSize = a.length - 1;
        for (int i = heapSize/2; i > 0; i--)
            downheap(a, i ,heapSize);
        while (heapSize > 1) {
            swap(a, 1, heapSize--);
            downheap(a, 1, heapSize);
        }
    }
    private static void downheap(Comparable[] a, int p, int heapSize) {
        while(2*p <= heapSize) {
            int s = 2*p;
            if(s < heapSize && isLess(a[s], a[s+1])) s++;
            if(!isLess(a[p], a[s])) break;;
            swap(a, p, s);
            p = s;
        }
    }

    private static boolean isLess(Comparable i, Comparable j) {
        return (i.compareTo(j) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
