package Student;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Student[] studs = {
				new Student(621118871, "강상원", "웅소", 2),
				new Student(621118872, "이순신", "정치", 3),
				new Student(621118873, "장미란", "경제", 4),
				new Student(621118874, "손흥민", "웅소", 3),
				new Student(621118875, "박태환", "경영", 2),
				new Student(621118876, "김연아", "국문", 1),
				new Student(621118877, "이상화", "영문", 1),
				new Student(621118878, "박지성", "컴공", 2)
		};
		
		Arrays.sort(studs);
		print(studs, "id");
		
		Arrays.sort(studs, Student.CompName);
		print(studs, "이름");
		
		Arrays.sort(studs, Student.CompDept);
		print(studs, "학과");
		
		Arrays.sort(studs, Student.CompGrade);
		print(studs, "학년");
	}
	public static void print(Student[] studs, String key) {
		System.out.println("");
		System.out.println( key + "로 정렬" );
		System.out.println("-----------------");
		for(Student s: studs) {
			System.out.println( s.getId() + " " + s.getName() + " " + s.getDept() +" " + s.getGrade());
		}
	};
}
