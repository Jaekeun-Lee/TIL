package bitcamp013.homework;

import java.util.ArrayList;

public class Util {
	public int findPrimeCount(int limit) {
		int cnt = 1; // 소수 '2'를 포함하고 시작

		for (int i = 2; i <= limit; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					break; // 나누어지면 다음숫자로
				else if (j == (i - 1))
					cnt++; // 소수면 카운트++
			}
		}
		return cnt;

	}

	public int[] findPrimeReturnArray(int limit) {

		// 소수 찾으면서 기록할 ArrayList생성
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(2); // 초기값 2 추가

		// limit까지의 소수 구하기
		for (int i = 2; i <= limit; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					break; // 나누어지면 다음숫자로
				else if (j == (i - 1)) {
					temp.add(i);
				}
			}
		}

		// 리턴 배열 생성
		int[] returnArr = new int[temp.size()];

		// ArrayList -> 배열로 옮기기
		for (int i = 0; i < temp.size(); i++) {
			returnArr[i] = temp.get(i);
		}

		return returnArr;
	}
}
