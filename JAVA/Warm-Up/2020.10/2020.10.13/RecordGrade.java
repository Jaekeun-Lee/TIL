 
import java.util.Scanner;

public class RecordGrade {

	public static char checkGrade(double avg) {
		char c = 'F';
		switch ((int) avg / 10) {
			case 10:
			case 9:
				c = 'A';
				break;
	
			case 8:
				c = 'B';
				break;
	
			case 7:
				c = 'C';
				break;
	
			case 6:
				c = 'D';
				break;
		}

		return c;

	}

	public static void main(String[] args) {
		String stdNum = "";
		int kor = 0;
		int math = 0;
		int eng = 0;
		int java = 0;
		int sum = 0;
		double avg = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("학번을 입력해주세요 : ");
		stdNum = sc.nextLine();

		System.out.print("국어 성적을 입력해주세요 : ");
		kor = sc.nextInt();

		System.out.print("수학 성적을 입력해주세요 : ");
		math = sc.nextInt();

		System.out.print("영어 성적을 입력해주세요 : ");
		eng = sc.nextInt();

		System.out.print("자바 성적을 입력해주세요 : ");
		java = sc.nextInt();

		sc.close();

		sum = kor + math + eng + java;
		avg = sum / 4.0;
		System.out.println("---------------------");
		System.out.println("학번 : " + stdNum);
		System.out.println("---------------------");
		System.out.println("국어 : " + kor);
		System.out.println("수학 : " + math);
		System.out.println("영어 : " + eng);
		System.out.println("자바 : " + java);
		System.out.println("---------------------");
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("학점 : " + RecordGrade.checkGrade(avg));
		System.out.println("---------------------");

	}

}
