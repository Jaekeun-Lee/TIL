package programmers.level1;

import java.util.ArrayList;

public class Distinct {

	public int[] solution(int[] arr) {
		ArrayList<Integer> al = new ArrayList<>();
		int preNum = -1;
		for (int i = 0; i < arr.length; i++) {

			if (preNum != arr[i]) {
				al.add(arr[i]);
			}
			preNum = arr[i];

		}
		int[] answer = new int[al.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i).intValue();
		}

		return answer;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		int[] arr2 = { 4, 4, 4, 3, 3 };

		Distinct dt = new Distinct();

		for (int a : dt.solution(arr)) {
			System.out.print(a);
		}
		System.out.println();
		for (int a : dt.solution(arr2)) {
			System.out.print(a);
		}

	}

}
