//자료구조 과제 #2 60211887 강상원
package DS4;

public class main {

	public static void main(String[] args) {
		SList<String> s = new SList<String>();
		s.insertFront("orange"); s.insertFront("apple");
		s.insertAfter("cherry", s.head.getNext());
		s.insertFront("pear");
		
		s.print();
		System.out.println(": s의 길이 = " + s.size() + "\n");
		System.out.println("체리가 \t" + s.search("cherry") + "번째에 있다.");
		System.out.println("키위가 \t" + s.search("kiwi") + "번째에 있다. \n");
		s.deleteAfter(s.head);
		s.print();
		System.out.println(": s의 길이 = " + s.size()); System.out.println();
		s.deleteFront();
		s.print();
		System.out.println(": s의 길이 = " + s.size()); System.out.println();
		
		SList<Integer> t = new SList<Integer>();
		t.insertFront(500); t.insertFront(200);
		t.insertAfter(400, t.head);
		t.insertFront(100);
		t.insertAfter(300, t.head.getNext());
		t.print();
		System.out.println(": t의 길이 = " + t.size());
		
		//17번
		SList<Integer> s1 = new SList<Integer>();
		s1.insertFront(10); s1.insertAfter(20, s1.head); s1.insertAfter(30, s1.head.getNext()); s1.insertAfter(40, s1.head.getNext().getNext()); s1.insertAfter(50, s1.head.getNext().getNext().getNext());
		System.out.print("Sorted List 1: ");
		s1.print();
		
		SList<Integer> s2 = new SList<Integer>();
		s2.insertFront(15); s2.insertAfter(18, s2.head); s2.insertAfter(35, s2.head.getNext()); s2.insertAfter(37, s2.head.getNext().getNext()); s2.insertAfter(55, s2.head.getNext().getNext().getNext());
		System.out.print("Sorted List 2: ");
		s2.print();
		
		SList<Integer> s3 = new SList<Integer>();
		s3.mergeLists(s1.head, s2.head);
		System.out.print("Merged List:   ");
		s3.print();
		
		System.out.println("----------------------------------------");
		System.out.println();
		
		//20번
		int[] newArr = {45, 17, 20, 50, 57, 35, 10, 15, 90, 10};
		SList<Integer> s4 = new SList<Integer>();
		
		for(int i = 0; i < newArr.length; i++) {
			s4.insertFront(newArr[i]);
		}
		System.out.print("Single List:   ");
		s4.print();
		
		SList<Integer> s5 = new SList<Integer>();
		SList<Integer> s6 = new SList<Integer>();
		
		System.out.println("K=20을 기준으로 두 개의 리스트로 분리: ");
		s4.splitList(s4.head, 20, s5, s6);
		System.out.print("List 1(<=20):  ");
		s5.print();
		System.out.print("List 2(> 20):  ");
		s6.print();
	}
	
	

}
