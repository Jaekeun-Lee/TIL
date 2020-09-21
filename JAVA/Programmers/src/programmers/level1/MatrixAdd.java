package programmers.level1;

import java.util.Arrays;

public class MatrixAdd {


	public static int[][] matrixAdd(int[][] arr1, int[][] arr2){
		int [][] answer = new int [arr1.length][arr1[0].length];
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				answer[i][j]=arr1[i][j]+arr2[i][j];
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2 },
						 { 2, 3 } };
		
		int[][] arr2 = { { 3, 4 }, 
						 { 5, 6 } };
		
		int [][] result = matrixAdd(arr1, arr2);
		for(int[] a:result) {
			System.out.println(Arrays.toString(a));
		}
	}

}
