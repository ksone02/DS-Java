// 자료구조 과제 #8 (60211887 강상원)
package DS11;

public class main {
    public static void main(String[] args) {
        Entry[] a = new Entry[16];

        BHeap h = new BHeap(a, 0);

        System.out.println("힙 만들기 전: "); h.print();

        h.insert(80, "80"); h.print();
        h.insert(40, "40"); h.print();
        h.insert(70, "70"); h.print();
        h.insert(30, "30"); h.print();
        h.insert(60, "60"); h.print();
        h.insert(20, "20"); h.print();
        h.insert(50, "50"); h.print();
        h.insert(10, "10"); h.print();

    }
}
