//자료구조 과제 #4 (60211887 강상원)

package Postfix_Notation;
import java.util.EmptyStackException;

public class ListStack <E>{
	private Node<E> top;
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	
	public E peek() {
		if(isEmpty())
			throw new EmptyStackException();
		
		return top.getItem();
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size == 0;}
	
	public void push(E newItem) {
		Node newNode = new Node(newItem, top);
		
		top = newNode;
		size++;
	}
	
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		
		return topItem;
	}
}
