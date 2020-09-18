package bitcamp015;

public class StringReplace {

	public static String myReplace(String str, char oldChar, char newChar) {
		// replace method 사용
		//return str.replace(oldChar, newChar);
		
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			newStr += (str.charAt(i) == oldChar) ? newChar : str.charAt(i);
		}
		
		return newStr;
		
	}

	public static void main(String[] args) {

		System.out.println("문자열에 특정 문자 변경하는 테스트");
		System.out.println("=======================Sample1=======================");
		System.out.println(myReplace("hello world", 'l', '*'));

		System.out.println("=======================Sample2=======================");
		System.out.println(myReplace("hello world", ' ', '-'));

		System.out.println("=======================Sample3=======================");
		System.out.println(myReplace("hello world", 'a', '*'));
	}

}
