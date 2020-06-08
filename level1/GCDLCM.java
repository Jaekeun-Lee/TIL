package programmers.level1;

public class GCDLCM {

	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if(n>m) {
        	int temp = m;
        	m = n;
        	n = temp;
        }
        int mul = n*m;
        int r = 1;
        while(r != 0) {
        	r = m % n;
        	m = n;
        	n = r;
        }
        
        int gcd = m;
        int lcm = mul/gcd;
        
        answer[0]+=gcd;
        answer[1]+=lcm;
        
        return answer;
    }
	
	public static void main(String[] args) {
		GCDLCM gl = new GCDLCM();
		
		int n = 3;
		int m = 12;
		
		System.out.println(gl.solution(n, m));

	}

}
