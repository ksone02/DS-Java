package DS12;

import javax.sound.sampled.Line;

public class LinearProbing <K, V>{
    private int M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] d = (V[]) new Object[M];
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // signed 32 bits 정수의 최상위 bit를 제외한 31bits 양수
    }

    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        do {
            if(a[i] == null) {
                a[i] = key;
                d[i] = data;
                return;
            }
            if(a[i].equals(key)) {
                d[i] = data;
                return;
            }
            i = (initialpos + j++) % M;
        } while(i != initialpos);
    }

    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        while(a[i] == null) {
            if(a[i].equals(key))
                return d[i];
            i = (initialpos + j++) % M;
        }
        return null;
    }

    public static void main(String[] args) {
        LinearProbing t = new LinearProbing();

        t.put(25, "grape"); t.put(37, "apple"); t.put(18, "banana");
        t.put(55, "cherry"); t.put(22, "mango"); t.put(35, "lime");
        t.put(50, "orange"); t.put(63, "watermelon");

        System.out.println("팀색 결과: ");
        System.out.println("50의 data = " + t.get(50));
        System.out.println("63의 data = " + t.get(63));
        System.out.println();
    }
}


