package programmers_level1;

import java.util.HashMap;

public class GymSuit {
	public static int solution(int n, int[] lost, int[] reverse) {
		HashMap<Integer, Integer> stu = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {	//일단 학생들이 체육복을 한벌씩 가져왔다고 생각.
			stu.put(i+1, 1);
		}
		
		for(int i = 0;  i < lost.length; i++) {	//잃어버린 학생들 체육복을 0개로 바꿈
			stu.put(lost[i], 0);
		}
		
		for(int i = 0; i < reverse.length; i++) {	//여벌이 있는 학생들껄 하나씩 추가함.
			stu.put(reverse[i], stu.get(reverse[i]) + 1);
		}
		//여기 까지 전제조건 끝.
		
		int count = 0;
		int i = 1;
		if(stu.get(1) == 0) {		//처음과 끝사람은 오른쪽, 왼쪽에서 빌림
			if(stu.get(2) == 2) {
				stu.put(1, 1);
				stu.put(2, 1);
			}
		}
		int lastP = stu.size();
		if(stu.get(lastP) == 0) {
			if(stu.get(lastP -1) ==2) {
				stu.put(lastP, 1);
				stu.put(lastP-1, 1);
			}
		}
		
		for(i = 2; i < stu.size(); i++) {
			if(stu.get(i) == 0) {
				if(stu.get(i-1)== 2) {
					stu.put(i-1, 1);
					stu.put(i, 1);
					continue;
				}
				if(stu.get(i+1) == 2) {
					stu.put(i+1,1);
					stu.put(i,1);
					continue;
				}
			}
		}
		int c = 1;
		while(c < stu.size()+1) {
			if(stu.get(c) == 0) {
				count++;
			}
			c++;
		}
		return stu.size() - count;
	}
}
