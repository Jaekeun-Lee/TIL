package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class StringSorting {

	public String[] solution(String[] strings, int n) {

		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < strings.length; i++) {
			arr.add("" + strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(arr);
		String[] answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i).substring(1, arr.get(i).length());
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] strings = { "sun", "bed", "car" };
		String[] strings2 = { "abce", "abcd", "cdx" };

		for(String s:new StringSorting().solution(strings, 1)) {
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s:new StringSorting().solution(strings2, 2)) {
			System.out.print(s+" ");
		}

	}

}
