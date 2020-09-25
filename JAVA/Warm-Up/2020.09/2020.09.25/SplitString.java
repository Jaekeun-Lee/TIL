

import java.util.Arrays;

public class SplitString {

	private static String[] stringSplit(String str1, String str2) {
		
		return str1.split(str2);
		
	}
	
	public static void main(String[] args) {
		String str = "PROD-001#X-note#Samsung#3#600000";
		String[] strs = stringSplit(str,"#");
		
		System.out.println("== 문자열 처리 결과 ==");
		
		System.out.println(Arrays.toString(strs));
	}

}
