// 자료구조 과제 #8 (60211887 강상원)
package DS11;

public class BHeap <Key extends Comparable<Key>, Value>{
    private Entry[] a;
    private int N;
    public BHeap(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }

    public int size() {return N;}

    private boolean greater(int i, int j) { // i j 인덱스 비교
        return a[j].getKey().compareTo(a[i].getKey()) < 0;
    }

    private void swap(int i, int j) { // Entry 자체를 교환하는 것
        Entry temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public void print() {
        for(int i = 1; i < N+1; i++) {
            System.out.print("["+a[i].getKey()+" "+a[i].getValue()+"]");
        }

        System.out.println();
        System.out.println("힙 크기 = " + size() + "\n\n");
    }

    public void createHeap() {
        for(int i = N/2; i > 0; i--) {
            downheap(i);
        }
    }

    private void downheap(int i) {
        while(2*i <= N) { // 왼쪽 자식이 있을 때
            int k = 2*i; // 왼쪽 자식의 index
            if(k < N && greater(k, k+1)) k++; // 왼쪽 자식이 더 작으면 k 그대로  오른쪽 자식이 더 작으면 k 값을 오른쪽 자식으로 바꿔준다.
            if(!greater(i, k)) break;
            swap(i, k);
            i = k;
        }
    }

    public Entry deleteMin() {
        Entry min = a[1];
        swap(1, N--);
        a[N + 1] = null;
        downheap(1);
        return min;
    }

    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey, newValue);
        a[++N] = temp;
        upheap(N);
    }

    private void upheap(int j) {
        while(j > 1 && greater(j/2, j)) {
            swap(j/2, j);
            j = j/2;
        }
    }
}
