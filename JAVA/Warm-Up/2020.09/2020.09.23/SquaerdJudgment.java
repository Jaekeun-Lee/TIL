package programmers.level1;

public class SquaerdJudgment {

	public static int pow(int n) {
		double sqrt = Math.sqrt(n);
		
		if (sqrt%1 != 0) {
			return -1;
		}
		else {
			return (int)Math.pow((sqrt+1), 2);
		}
	}

	public static void main(String[] args) {
		int n = 121;

		System.out.println(pow(n));
	}

}
