package DS13;

public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int low, int high) {
        if(high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j+1, high);
    }
    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot + 1;
        int j = high;
        Comparable p = a[pivot];
        while(true) {
            while(i <= high && !isless(p, a[i])) i++; // 같은 값이 들어있으면 infinite error
            while(j >= pivot && isless(p, a[j])) j--;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, pivot, j);
        return j;
    }
    private static boolean isless(Comparable u, Comparable v) {
        return (u.compareTo(v) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
