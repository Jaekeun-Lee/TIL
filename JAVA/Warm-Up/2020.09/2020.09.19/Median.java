package bitcamp015;

import java.util.Arrays;

public class Median {

	public static int findMedian(int[] values) {
		int median = (values.length % 2 == 0) ? (values.length / 2) - 1 : values.length / 2;
		Arrays.sort(values);

		return values[median];
	}

	public static void main(String[] args) {

		int[] values1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };
		int[] values2 = { 32, 53, 52, 76, 15, 98, 96, 65, 36, 10 };

		System.out.println("input ==> " + Arrays.toString(values1));
		System.out.println("median ==> " + findMedian(values1));
		System.out.println("\n===============================================\n");
		System.out.println("input ==> " + Arrays.toString(values2));
		System.out.println("median ==> " + findMedian(values2));
	}

}
