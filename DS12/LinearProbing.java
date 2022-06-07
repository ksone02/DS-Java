// 자료구조 과제 #9 (60211887 강상원)
package DS12;

public class LinearProbing <K, V>{
    private int M = 11;
    private K[] a = (K[]) new Object[M];
    private V[] d = (V[]) new Object[M];
    private int conflict = 0;
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
            conflict++;
            System.out.println("입력 값: " + key + ", " + i + " 위치에서 충돌");
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

        t.put(71, "71"); t.put(23, "23"); t.put(73, "73");
        t.put(49, "49"); t.put(54, "54"); t.put(89, "89");
        t.put(39, "39");

        System.out.println("총 충돌 횟수 : " + t.conflict);

        System.out.println("해시 테이블:");
        for(int i = 0; i< t.M; ++i) System.out.printf("\t%2d", i);
        System.out.println();
        for(int i = 0; i<t.M; ++i) System.out.printf("\t"+t.a[i]);
        System.out.println();
    }
}


