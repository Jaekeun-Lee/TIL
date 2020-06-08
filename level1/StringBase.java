//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
//예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

package programmers.level1;

public class StringBase {
	public boolean solution(String s) {
        boolean answer = true;
        if( s.length() == 4 || s.length() == 6) {
        	try{
        		Integer.parseInt(s);
        		return answer;
        	}catch (NumberFormatException e) {
        		return false;
        	}
        }
        else {

        	return false;
        }
    }
	
	public static void main(String[] args) {
		StringBase sb = new StringBase();
		String a = "a234";
		String b = "1234";
		String c = "12346z";
		String d = "1.2341";
		String e = "1234 5";
		
		System.out.println(sb.solution(a)+" "+sb.solution(b)+" "+sb.solution(c)+" "+sb.solution(d)+" "+sb.solution(e));
		System.out.println("F,T,F,F,F?");

	}

}
