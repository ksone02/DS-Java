// 자료구조 과제 #1 60211887 강상원
package Hanoi;

import java.util.Scanner;

public class Hanoi {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 
		int N = in.nextInt();
		System.out.println("원반이 "+ N +"개인 경우");
 
		hanoi(N, 'A', 'B', 'C');
		System.out.println(sb);
	}

	
	public static void hanoi(int N, char start, char mid, char to) {
		// 이동할 원반의 개수가 1개라면
		if (N == 1) {
			sb.append("원반 " + N + "을 " + start + "에서 " + to + "로 이동\n");
			return;
		}
		 
		// A -> C로 옮긴다고 가정할 떄,
		// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)				
		hanoi(N - 1, start, to, mid);

		// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
		sb.append("원반 " + N + "을 " + start + "에서 " + to + "로 이동\n");

		// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		hanoi(N - 1, mid, start, to);
	}

}
