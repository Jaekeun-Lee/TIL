package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveSmallestNumber {

	public static int[] removeNum(int[] arr) {
		
		
		if (arr.length ==0  || arr[0] == 10) {
			int [] temp = {-1};
			return temp;
		}

		int [] answer= new int [arr.length-1];
		ArrayList <Integer> al = new ArrayList<Integer>();
		for(int i: arr) al.add(i);
		
		Integer minNum = Collections.min(al);
		al.remove(minNum);
		
		for (int i = 0; i < answer.length; i++) {
			answer[i]=al.get(i);
		}
		
		
		return answer;
	}

	public static void main(String[] args) {

		int[] arr = { 4, 3, 2, 1 };
		int[] arr2 = { 10 };
		int[] arr3 = {};


		for(int a : removeNum(arr)) {
			System.out.print(a+" ");
		}
	}

}
