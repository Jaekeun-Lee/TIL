package programmers.level1;

public class MakingWeirdString {

	public String solution(String s) {

		int count = 0;
		String answer = "";

		String[] arr = s.split("");

		for (String str : arr) {
			count = str.contains(" ") ? 0 : ++count;
			answer += count % 2 == 1 ? str.toUpperCase() : str.toLowerCase();
		}

		return answer;
	}

	public static void main(String[] args) {
		String s1 = "try hello world";
		System.out.println(new MakingWeirdString().solution(s1));

	}

}
