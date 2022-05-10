package DS5;

public class main {

	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		stack.print();
		
		System.out.println(stack.peek());
		stack.push("pear");
		stack.print();
		
		stack.pop();
		stack.print();
		
		System.out.println(stack.peek());
		stack.push("grape");
		stack.print();
		
		System.out.println();
		
		ListStack<String> stack2 = new ListStack<String>();
		
		stack2.push("apple");
		stack2.push("orange");
		stack2.push("cherry");
		stack2.print();
		
		System.out.println(stack2.peek());
		stack2.push("pear");
		stack2.print();
		
		stack2.pop();
		stack2.print();
		
		System.out.println(stack2.peek());
		stack2.push("grape");
		stack2.print();
	}

}
