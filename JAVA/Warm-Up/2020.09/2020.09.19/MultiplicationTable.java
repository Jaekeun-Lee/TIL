package bitcamp015;

import java.util.Scanner;

public class MultiplicationTable {

	public static void multiplicationTablePrint(int num) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= num; j++) {
				System.out.print(String.format("%d * %d = %2d | ", j,i,(i*j)));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int num = 0;
		int count = 1;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("숫자를 입력해주세요(종료:'-1') = ");
			num = sc.nextInt();
			
			if (num==-1) break;
			else if (num < 1 || 9 < num) System.out.println("1 ~ 9 사이의 값을 입력하셔야 합니다.");
			else {
				System.out.println("--------------------------Sample"+count+"--------------------------");
				multiplicationTablePrint(num);
				
				count++;
			}
		}

		sc.close();
	}

}
