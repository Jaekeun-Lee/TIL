import java.util.Scanner;

public class Encoding {

	public static void main(String[] args) {
		//String sourceString = "everyday we have is one more than we deserve";
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("영어로 문장을 입력해주세요 : ");
		String sourceString = sc.nextLine();
		sc.close();
		
		String encodedString ="";
		int ascii;
		
		for (int i = 0; i < sourceString.length(); i++) {
			ascii = sourceString.charAt(i);
			if(sourceString.charAt(i)==' ') {
				encodedString+=' ';
			}else {
				ascii+=3;
				if(ascii>122) {
					ascii-=26;
				}
				encodedString+=(char)ascii;
			}
			
			
		}
		
		
		System.out.println("암호화 할 문자열 = "+ sourceString);
		System.out.println("암호화 된 문자열 = "+encodedString);
	}

}
