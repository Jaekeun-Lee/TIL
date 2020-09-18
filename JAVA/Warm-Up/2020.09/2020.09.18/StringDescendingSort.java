import java.util.Arrays;

public class StringDescendingSort {

	public String solution(String s) {
		
		int [] arr = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			arr[i]=s.charAt(i);
		}
		
		Arrays.sort(arr);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = arr.length-1; i>=0; i--) {
			sb.append((char)arr[i]);
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "Zbcdefg";
		
		System.out.println(new StringDescendingSort().solution(s));
		
	}

}
