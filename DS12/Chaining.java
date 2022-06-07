// 자료구조 과제 #9 (60211887 강상원)
package DS12;

public class Chaining<K, V> {
    private int M = 11;
    private Node[] a = new Node[M];
    public static class Node {
        private Object key;
        private Object data;
        private Node next;
        public Node(Object newkey, Object newdata, Node ref) {
            key = newkey;
            data = newdata;
            next = ref;
        }
        public Object getKey() { return key != null ? key : null; }
        public  Object getData() { return data; }
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next)
            if (key.equals(x.key)) return (V) x.data;
        return null;
    }
    private void put(K key, V data) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next)
            if(key.equals(x.key)) {
                x.data = data;
                return;
            }
        a[i] = new Node(key, data, a[i]);
    }

    public static  void main(String[] args) {
        Chaining c = new Chaining();

        c.put(71, "71"); c.put(23, "23"); c.put(73, "73");
        c.put(49, "49"); c.put(54, "54"); c.put(89, "89");
        c.put(39, "39");

        System.out.println("해시 테이블:");
        for(int i = 0; i < c.M; ++i) System.out.printf("\t%2d", i);
        System.out.println();
        for(int i = 0; i < c.M; ++i) {
            if(c.a[i] != null) {
                System.out.printf("\t"+ c.a[i].getKey());
            } else {
                System.out.printf("\t" + c.a[i]);
            }
        }
        System.out.println();
    }
}
