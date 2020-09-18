package programmer;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sumnum = 0;
        
        for(int i = 0; i < d.length; i++) {
        	if(sumnum>budget) {
        		break;
        	}
        	sumnum += d[i];
        	answer = i;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		Budget bg = new Budget();
		int [] d = {2,2,3,3}; 
		int budget = 10;
		
		int a = bg.solution(d, budget);
		System.out.println(a);

	}

}