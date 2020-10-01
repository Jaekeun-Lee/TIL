package kakao;

import java.util.Arrays;

public class Budget {

	public static int solution(int[] apply, int budget) {

		int temp = 0;
		int count = 0;
		Arrays.sort(apply);

		for (int i = 0; i < apply.length; i++) {
			temp += apply[i];
			count++;
			if (temp > budget) {
				count--;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		// 입출력 예시
		int[] apply = { 1, 3, 2, 5, 4 };
		int budget = 9;

		System.out.println(Budget.solution(apply, budget));
	}

}
