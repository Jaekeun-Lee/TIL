//단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

package programmer;

public class CenterChar {
	
	public String solution(String s) {
        String answer = "";
        int pick = s.length() / 2;
        if(s.length() % 2 == 0) {
        	answer += s.charAt(pick-1);
        	answer += s.charAt(pick);
        }
        else {
        	answer += s.charAt(pick);
        }
        return answer;
    }

	public static void main(String[] args) {
		CenterChar cc = new CenterChar();
		String s1 = "qwer";
		String s2 = "abcde";
		System.out.println("InputString : qwer\n" + cc.solution(s1) + "\nInputString : abcde\n"+cc.solution(s2));

	}

}
