package programmer;

import java.util.Arrays;

public class Descending {
	public String solution(String s) {
		String answer = "";
		char[] array = s.toCharArray(); 
		Arrays.sort(array); 
		StringBuilder sb = new StringBuilder();
		
		sb.append(array);
		answer = sb.reverse().toString();
	    return answer;
	}
	public static void main(String[] args) {
		Descending des = new Descending();
		String input = "Zbcdefg";
		System.out.println(des.solution(input));
	}

}
