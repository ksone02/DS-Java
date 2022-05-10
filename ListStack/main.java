//자료구조 과제 #3 (60211887 강상원)
package ListStack;

public class main {

	public static void main(String[] args) {
		String s1 = "{{(){()}}}";
		String s2 = "{{(){()})()}";
		ListStack ls1 = new ListStack();
		ListStack ls2 = new ListStack();
		
		solution(ls1, s1);
		solution(ls2, s2);
	}
	public static void solution(ListStack ls, String s) {
		int errCheck = 0;
		
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case ')':
				if(ls.peek().toString().charAt(0) == '(') ls.pop();
				else errCheck = i;
				break;
			case '}':
				if(ls.peek().toString().charAt(0) == '{') ls.pop();
				else errCheck = i;
				break;
			default:
				ls.push(s.charAt(i));
				break;
			}
		}
		
		if(ls.isEmpty()) System.out.println("괄호 짝이 맞다");
		else System.out.println("입력스트링 " + errCheck + " 부분에서 짝이 맞지 않다.");
	}
}
