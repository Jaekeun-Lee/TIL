import java.util.Scanner;

public class PrintSeason {

	public void printSeason(int num) {
		if (!(0 < num && num < 13)) {
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
		}
		else if (3<=num && num<=5) {
			System.out.println("봄에 태어나셨네요.");
		}
		else if (6<=num && num<=8) {
			System.out.println("여름에 태어나셨네요.");
		}
		else if (9<=num && num<=11) {
			System.out.println("가을에 태어나셨네요.");
		}
		else if (num==1||num==2||num==12) {
			System.out.println("겨울에 태어나셨네요.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("태어난 달을 입력해주세요 : ");
		int month = sc.nextInt();
		sc.close();
		
		new PrintSeason().printSeason(month);
		
	}

}
