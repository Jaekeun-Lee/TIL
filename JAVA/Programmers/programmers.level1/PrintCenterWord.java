
package programmers.level1;

public class PrintCenterWord {
	public String solution(String str) {

		return str.substring((str.length() - 1) / 2, str.length() / 2 + 1);
	}

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "qwer";

		System.out.println(new PrintCenterWord().solution(s1));
		System.out.println(new PrintCenterWord().solution(s2));

	}

}
