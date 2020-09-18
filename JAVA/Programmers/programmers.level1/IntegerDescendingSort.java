package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class IntegerDescendingSort {

	public static void main(String[] args) {

		int n = 118372;
		String str = String.valueOf(n);

		Integer[] arr = new Integer[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = Integer.parseInt(str.charAt(i) + "");
		}

		Arrays.sort(arr, Collections.reverseOrder());

		for (int i : arr) {
			System.out.print(i);
		}

	}

}
