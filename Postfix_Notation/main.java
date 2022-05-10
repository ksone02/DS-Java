//자료구조 과제 #4 (60211887 강상원)
package Postfix_Notation;

public class main {

	public static void main(String[] args) {
		solution("A-B+C/D");
		solution("A/B-C*D");
		solution("A-B*C+D/E-F");
		solution("(A-B)*C-(D/(E+F))");

	}
	
	public static void solution(String s) {
		ListStack ls = new ListStack();
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char input = s.charAt(i);
			if(input >= 'A' && input <= 'Z') {
				answer.append(input + "");
			} else {
				switch(input) {
				case '*':
				case '/':
				case '+':
                case '-':
                	while(!ls.isEmpty() && priority(ls.peek().toString().charAt(0)) >= priority(input)) {
                		answer.append(ls.pop());
					}
                    ls.push(input);
                    break;

                case '(':
                    ls.push(input);
                    break;
                        
                case ')':
                    while(!ls.isEmpty() && ls.peek().toString().charAt(0) != '('){
                        answer.append(ls.pop());
                    }
                    ls.pop();
                    break;
				}
			}
		}
		
		while(!ls.isEmpty()){
            answer.append(ls.pop());
        }
		
		System.out.println(answer);
	}
	
	public static int priority(char operator) {
		if(operator == '(' || operator == ')') {
			return 0;
		} else if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return -1;
	}

}
