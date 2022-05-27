package DS12;

public class DoubleHashing<K, V> {
    private int N = 0, M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] dt = (V[]) new Object[M];
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // signed 32 bits 정수의 최상위 bit를 제외한 31bits 양수
    }

    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        int d = (7 - (int)key % 7);
        do {
            if(a[i] == null) {
                a[i] = key;
                dt[i] = data; N++;
                return;
            }
            if(a[i].equals(key)) {
                dt[i] = data;
                return;
            }
            i = (initialpos +j * d) % M;
        } while(N < M);
    }

    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        int d = (7 - (int)key % 7);
        while(a[i] == null) {
            if(a[i].equals(key))
                return dt[i];
            i = (initialpos +j * d) % M;
        }
        return null;
    }
}
