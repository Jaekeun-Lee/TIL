package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeTest {
	public int[] solution(int[] answers) {

		int[] human1Pattern = { 1, 2, 3, 4, 5 }; // 5ea
		int[] human2Pattern = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8ea
		int[] human3Pattern = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10ea

		List<Integer> humanAns = new ArrayList<Integer>(3);
		for (int reset = 0; reset < 3; reset++) {
			humanAns.add(0);
		}
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == human1Pattern[i % human1Pattern.length])
				humanAns.set(0, humanAns.get(0) + 1);
			if (answers[i] == human2Pattern[i % human2Pattern.length])
				humanAns.set(1, humanAns.get(1) + 1);
			if (answers[i] == human3Pattern[i % human3Pattern.length])
				humanAns.set(2, humanAns.get(2) + 1);
		}

		int max = Math.max(humanAns.get(0), Math.max(humanAns.get(1), humanAns.get(2)));

		
		
		List<Integer> answer = new ArrayList<Integer>();

		for(int i=0;i<humanAns.size();i++) {
			if(humanAns.get(i)==max) {
				answer.add(i+1);
			}
		}
		
		

		
		return answer.stream().mapToInt(i->i.intValue()).toArray();
	}

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(new PracticeTest().solution(answers)));
	}

}
