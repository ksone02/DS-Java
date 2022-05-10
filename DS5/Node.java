//자료구조 과제 #3 (60211887 강상원)

package DS5;

public class Node <E> {
	private E item;
	private Node<E> next;
	
	public Node(E newItem, Node<E> p) {
		item = newItem;
		next = p;
	}
	
	public E getItem() {return item;}
	public Node<E> getNext() {return next;}
	public void setItem(E newItem) {item = newItem;}
	public void setNext(Node<E> newNext) {next = newNext;}
}
