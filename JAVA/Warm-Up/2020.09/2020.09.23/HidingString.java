package programmers.level1;

public class HidingString {

	
	public static String hiding(String s) {
		String temp = "";
		temp+=s.substring(0, s.length()-4).replaceAll("[0-9]","*");
		temp+=s.subSequence(s.length()-4, s.length());
		
		return temp;
	}
	
	public static void main(String[] args) {
		
		String phoneNumber = "01034567890";
		String phoneNumber2 = "0277778888";
		
		System.out.println(hiding(phoneNumber2));
	}

}
