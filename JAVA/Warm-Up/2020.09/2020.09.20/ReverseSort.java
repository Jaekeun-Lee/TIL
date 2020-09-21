package programmer;

import java.util.Arrays;

public class ReverseSort {

	public long solution(long n) {
        
        String num = String.valueOf(n);
        String ansnum = "";
        char [] arr = new char[num.length()];
        for (int i = 0; i < num.length(); i++) {
        	arr[i] += num.charAt(i);
        }
        
        Arrays.sort(arr);
        for (int i = arr.length-1; i >= 0; i--) {
        	ansnum += arr[i];
        }
        
        long answer = Long.parseLong(ansnum);
        return answer;
    }
	
	
	public static void main(String[] args) {
		ReverseSort rs = new ReverseSort();
		long test = 118372;
		System.out.println(rs.solution(test));

	}

}
