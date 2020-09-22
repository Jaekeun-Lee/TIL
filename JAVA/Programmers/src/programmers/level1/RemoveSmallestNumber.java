package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveSmallestNumber {

	public static int[] removeNum(int[] arr) {
		
		if (arr.length == 1 || arr[0] == 10) {
			int [] temp= {-1};
			return temp;
		}

		ArrayList <Integer> al = new ArrayList<Integer>();
		for(int i: arr) al.add(i);
		
		Integer minNum = Collections.min(al);
		
		
		al.remove(minNum);
		System.out.println(al.toString());
		
		
		
		
		return null;
	}

	public static void main(String[] args) {

		int[] arr = { 4, 3, 2, 1 };
		int[] arr2 = { 10 };
		int[] arr3 = {};

		removeNum(arr);
	}

}
