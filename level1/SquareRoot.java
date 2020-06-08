/*
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

				예
				n		return
				121		144
				3		-1
*/


package programmers.level1;
import java.lang.Math;

public class SquareRoot {
	public long solution(long n) {
        long answer = 0;
        double base = Math.sqrt(n);
        if ( base % 1 > 0 ) {
        	answer = -1;
        }
        else answer = (long) Math.pow(base+1, 2);
        return answer;
    }
	public static void main(String[] args) {
		SquareRoot sr = new SquareRoot();
		System.out.println(sr.solution(121));
	}

}
