package kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PickedIntegerAdd {

	public static int[] solution(int[] numbers) {
        
		Set<Integer> set = new HashSet<Integer>();//HashSet생성
		
		for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
		
		int[] answer = new int[set.size()];
		
		int index = 0;
		for (int i : set) {
			answer[index++]=i;
		}
		Arrays.sort(answer);
		return answer;
		
    }
	
	public static void main(String[] args) {
		//입출력 예시
		int [] numbers = {2,1,3,4,1};
		System.out.println(Arrays.toString(PickedIntegerAdd.solution(numbers)));
	}

}
