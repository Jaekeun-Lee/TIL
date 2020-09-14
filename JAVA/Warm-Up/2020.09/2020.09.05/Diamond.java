import java.util.Scanner;

// 입력 숫자가 중앙층이 되는 다이아몬드 
public class Diamond {

	// 상단 ~ 중앙까지 삼각형
	public static void draw(int num) {
		
		for (int i = num,count = 1; i > 0; i -= 2,count += 2) {

			// 라인 공백
			for (int j = 1; j <= (i / 2); j++) {
				System.out.print(" ");
			}

			// 별 찍기
			for (int star = 0; star < count; star++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for (int i = 1,count=num-2; i <= num; i += 2,count-=2) {

			// 라인 공백
			for (int j = 1; j <= i; j += 2) {
				System.out.print(" ");
			}

			// 별 찍기
			for (int star = 0; star < count; star++) {
				System.out.print("*");
			}

			
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("다이아몬드 중앙층의 갯수 숫자 입력(홀수만) : ");
		int num = sc.nextInt();

		// 유효성 검사
		if (num % 2 == 0) {
			System.out.println("홀수만 입력해주세요.");
		}

		else { // draw Method
			draw(num);

		}

		sc.close();
	}

}
