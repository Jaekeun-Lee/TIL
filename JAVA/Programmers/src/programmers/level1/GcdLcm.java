package programmers.level1;

public class GcdLcm {

	public static int[] gcdlcm(int n, int m) {
		
		int gcd = 0;
		int lcm = 0;
		int [] answer = new int [2];
		
		for(int i = 1; i<=n;i++) {
			if(n%i==0&&m%i==0) {
				gcd = i;
			}
		}
		
		for(int i=n*m;i>0;i--) {
			if(i%n==0&&i%m==0) {
				lcm = i;
			}
		}
		
		answer[0]=gcd;
		answer[1]=lcm;
		
		return answer;
	}
	public static void main(String[] args) {
		for(int i : gcdlcm(3, 12)) {
			System.out.println(i);
		}
	}

}
