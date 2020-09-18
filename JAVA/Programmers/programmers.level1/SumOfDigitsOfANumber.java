package programmers.level1;

public class SumOfDigitsOfANumber {

	public static void main(String[] args) {
		int a = 987;
		int result = 0;

		String s1 = String.valueOf(a);

		for (int i = 0; i < s1.length(); i++) {
			result += Integer.parseInt(s1.charAt(i) + "");
		}

		System.out.println(result);
	}

}
