import java.util.Scanner;

public class Factorial {

	public static int factorial(int n) {

		if (n < 2) {
			return n;
		} else {
			return n * factorial(n - 1);

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int num = sc.nextInt();
		sc.close();
		System.out.println(num + "! = " + factorial(num));
	}

}
