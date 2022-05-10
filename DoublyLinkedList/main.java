package DoublyLinkedList;

public class main {

	public static void main(String[] args) {
		DList<String> s = new DList<String>();
		
		s.insertAfter(s.head, "apple"); s.print();
		s.insertBefore(s.tail, "Orange"); s.print();
		s.insertBefore(s.tail, "Cherry"); s.print();
		s.insertAfter(s.head.getNext(), "Pear"); s.print();
		System.out.println();
		
		s.delete(s.tail.getPrevious()); s.print();
		System.out.println();
		
		s.insertBefore(s.tail, "grape"); s.print();
		System.out.println();
		
		s.delete(s.head.getNext()); s.print();
		s.delete(s.head.getNext()); s.print();
		s.delete(s.head.getNext()); s.print();
		s.delete(s.head.getNext()); s.print();
	}

}
