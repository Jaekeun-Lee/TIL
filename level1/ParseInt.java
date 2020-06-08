/*
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.*/


package programmers.level1;

public class ParseInt {
	
	public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toString(n);
        for (int i = 0 ; i < s.length(); i++) {
        	answer += Integer.parseInt(s.charAt(i)+"");
        }
        return answer;
    }
	
	public static void main(String[] args) {
		ParseInt pi = new ParseInt();
		
		int a = pi.solution(123);
		System.out.println(a);
		

	}
}
