package DS12;

import  java.util.Random;
public class RandProbing<K, V> {
    private int N = 0, M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] d = (V[]) new Object[M];
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // signed 32 bits 정수의 최상위 bit를 제외한 31bits 양수
    }

    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        Random rand = new Random();
        do {
            if(a[i] == null) {
                a[i] = key;
                d[i] = data; N++;
                return;
            }
            if(a[i].equals(key)) {
                d[i] = data;
                return;
            }
            i = (initialpos +rand.nextInt(1000)) % M;
        } while(N < M);
    }

    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        Random rand = new Random();
        rand.setSeed(10);
        while(a[i] == null) {
            if(a[i].equals(key))
                return d[i];
            i = (initialpos +rand.nextInt(1000)) % M;
        }
        return null;
    }
}
