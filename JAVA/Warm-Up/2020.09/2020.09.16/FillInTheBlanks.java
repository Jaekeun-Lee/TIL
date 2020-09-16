package bitcamp013.homework;

public class FillInTheBlanks {

	public String leftPad(String str, int size, char padChar) {

		if(str.length()>size) return str;
		
		String newStr = "";
		
		for (int i = 0; i < size-str.length(); i++) {
			newStr += padChar;
		}
		
		newStr+=str;
		
		return newStr;
	}

	public static void main(String[] args) {

		FillInTheBlanks fb = new FillInTheBlanks();

		System.out.println(fb.leftPad("ABC", 6, '#'));
		System.out.println(fb.leftPad("ABC", 5, '$'));
		System.out.println(fb.leftPad("ABC", 2, '&'));
		
	}

}
