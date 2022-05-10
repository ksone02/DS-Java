//자료구조 과제 #2 60211887 강상원
package DS4;

import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>> {
	protected Node head;
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}
	
	public void insertFront(E newItem) {
		head = new Node(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node p) {
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	
	public int search(E target) {
		Node p = head;
		
		for(int k = 0; k < size; k++) {
			if(target == p.getItem()) return k;
			p = p.getNext();
		}
		
		return -1;
	}
	
	public void deleteAfter(Node p) {
		if(p == null) throw new NoSuchElementException();
		
		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	public void deleteFront() {
		if(isEmpty()) throw new NoSuchElementException();
		
		head = head.getNext();
		size--;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

	public void print() {
		for (Node p = head; p != null; p = p.getNext())
			System.out.print(p.getItem()+"\t");
	}
	
	
	
	//17
	public void mergeLists(Node p1, Node p2) {
		Node newNode = new Node(null, null);
		Node handler = newNode;
		
		//p1과 p2가 모두 없어질 때 까지 반복
		while(p1 != null && p2 != null) {
			//compareTo메소드를 이용해서 p1의 아이템과 p2의 아이템을 비교
			if(p1.getItem().compareTo(p2.getItem()) <= 0) {
				handler.setNext(p1);
				p1 = p1.getNext();
			} else {
				handler.setNext(p2);
				p2 = p2.getNext();
			}
			handler = handler.getNext();
		}
		
		//비교 후 남은 노드는 맨 뒤에 붙여줌
		if(p1 != null) {
			handler.setNext(p1);
		} else if (p2 != null) {
			handler.setNext(p2);
		}
		
		//해당 클래스에 결과 노드 할당
		this.head = newNode.getNext();
	}
	
	//20번
	public void splitList(Node p, int k, SList l1, SList l2) {
		Node newNode = new Node(null, null);
		Node handler = newNode;
		
		Node newNode2 = new Node(null, null);
		Node handler2 = newNode2;
		
		//p가 없어질 때 까지 compareTo메소드를 통해 분류
		while(p != null) {
			if(p.getItem().compareTo(k) <= 0) {
				handler.setNext(p);
				p = p.getNext();
				handler = handler.getNext();
			} else {
				handler2.setNext(p);
				p = p.getNext();
				handler2 = handler2.getNext();
			}
		}
		
		//이미 분류는 끝났기 때문에 뒤에 남은 노드를 지워줌
		if(handler.getNext() != null) {
			handler.setNext(null);
		}
		if(handler2.getNext() != null) {
			handler2.setNext(null);
		}
		
		//l1과 l2에 분류된 노드 할당
		l1.head = newNode.getNext();
		l2.head = newNode2.getNext();
	}
}
