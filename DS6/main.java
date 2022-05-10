//강상원_60211887_DS6주차출석과제
package DS6;

public class main {
	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<String>();

		queue.add("apple"); queue.print();
		queue.add("orange"); queue.print();
		queue.add("cherry"); queue.print();
		queue.add("pear"); queue.print();
		
		queue.remove(); queue.print();
		
		queue.add("grape"); queue.print();
		
		queue.remove(); queue.print();
		
		queue.add("lemon"); queue.print();
		queue.add("mango"); queue.print();
		queue.add("lime"); queue.print();
		queue.add("kiwi"); queue.print();
		
		queue.remove(); queue.print();
	}
}
