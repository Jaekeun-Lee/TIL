import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("연도를 입력해주세요 : ");
		int year = sc.nextInt();
		int month = 2;
		int maxDay = 28;
		// 년도가 4로 나누어 떨어지면서 100으로 나뉘지 않고 그중에 400으로 나뉘어지면 윤년
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			maxDay++;
			System.out.println(year + "년도은 윤년이고, " + month + "월의 말일은 " + maxDay + "일 입니다.");
		} else
			System.out.println(year + "년도는 평년이고, " + month + "월의 말일은 " + maxDay + "일 입니다.");

		sc.close();
	}

}
