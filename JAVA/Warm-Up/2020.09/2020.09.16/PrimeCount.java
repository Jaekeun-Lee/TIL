package bitcamp013.homework;

import java.util.Scanner;

public class PrimeCount {

	public static void main(String[] args) {
		int limit;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자를 입력해주세요 : ");
			limit = sc.nextInt();

			if (limit > 1)
				break;
			else
				System.out.println("1이상의 숫자를 입력해주세요.");

		}
		sc.close();
		Util util = new Util();

		int primeCount = util.findPrimeCount(limit);
		System.out.println("1 ~ " + limit + "까지의 소수 갯수는 " + primeCount + "EA ");

		int[] primeArray = util.findPrimeReturnArray(limit);
		System.out.print("PrimeList ==> [ ");
		for (int i = 0; i < primeArray.length; i++) {
			System.out.print(primeArray[i] + ((primeArray.length - 1) != i ? "," : ""));
		}
		System.out.println(" ]");
	}

}
