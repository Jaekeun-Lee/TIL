import java.util.Scanner;

public class Factorial {

	public static int fact(int n) {

		if (n <= 2) {
			return n;
		} else {
			return n * fact(n - 1);
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		/*
		//1. for문 이용
		int result = 1 ;
		
		if (1 < num && num < 10) {
			for (int i=1; i<=num;i++) {
				result*=i;
				System.out.println(i+"! = "+result);
			}
		}else
			System.out.println("1보다 크고 10보다 작은 정수를 입력해야합니다...");
		*/
		
		
		
		//2. 재귀 함수
		if (1 < num && num < 10) {
			System.out.println(num + "! = " + fact(num));
		} else
			System.out.println("1보다 크고 10보다 작은 정수를 입력해야합니다...");
				
		sc.close();
	}

	
}
