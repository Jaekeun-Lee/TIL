public class AbsSubtraction {

	public int abs(int num1, int num2) {
		int result = 0;

		if (num1 < 0) {
			num1 *= -1;
		}

		else if (num2 < 0) {
			num2 *= -1;
		}

		result = num1 - num2;

		if (result < 0) {
			result *= -1;
		}

		return result;

	}

	public static void main(String[] args) {
		int num1 = 6;
		int num2 = 15;

		Prob08 prob = new Prob08();
		System.out.println("두 수의 차는 : " + prob.abs(num1, num2));
	}

}
