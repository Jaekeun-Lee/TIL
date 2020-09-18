package bitca

import java.util.ArrayList;
import java.util.Scanner;

public class VarietyValueUsingIntArray {

	private static void calc(ArrayList<Integer> al) {
		int total = 0;
		double average = 0.0;
		
		for (int i = 0; i<al.size(); i++) {
			total += al.get(i);
		}
		
		average = (double)total / al.size();
		al.sort(null);

		System.out.println("The largest value = " + al.get(al.size()-1));
		System.out.println("The smallest value = " + al.get(0));
		System.out.println("The total value = " + total);
		System.out.println("The average value = " + average);

	}

	public static void main(String[] args) {

		int cnt = 1;
		int test = 0;

		ArrayList<Integer> al = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		System.out.println("입력한 값들의 largest / smallest / sum / average 구하기"
				+ "\n====================================================\n" + "값들을 입력해주세요 ( 입력완료시 ' -1 ' )");

		// 숫자 하나씩 입력받고 ArrayList에 담기
		while (true) {
			System.out.print(cnt + "번째 숫자 입력 = ");
			test = sc.nextInt();
			if (test == -1)
				break;
			else if (test < 0 || test > 9999) {
				System.out.println("0~9999까지의 정수를 입력해주세요.");
				cnt--;
			} else
				al.add(test);
			cnt++;

		}
		sc.close();
	
		System.out.println("입력 받은 수 ==>"+al);
		
		calc(al);
	}
}
