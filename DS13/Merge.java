package DS13;

public class Merge {
    private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for(int k = low; k <= high; k++) {
            if(i > mid) b[k] = a[j++];
            else if (j > high) b[k] = a[i++];
            else if(isless(a[j], a[i])) b[k] = a[j++];
            else b[k] = a[i++];
        }
        for (int k = low; k <= high; k++) a[k] = b[k];
    }
    private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
        if(high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, b, low, mid);
        sort(a, b, mid + 1, high);
        merge(a, b, low, mid, high);
    }
    public static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, 0, a.length - 1);
    }
    private static boolean isless(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
