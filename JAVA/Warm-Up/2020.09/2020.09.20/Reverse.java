package programmer;

public class Reverse {

	public int[] solution(long n) {
        
        String num = Long.toString(n);
        int[] answer = new int[num.length()];
        int index = 0;
        for (int i = num.length()-1; i >= 0; i--) {
        	answer[index++] += Integer.parseInt(num.charAt(i)+"");
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Reverse re = new Reverse();
		long a = 12345;
		System.out.println(re.solution(a));

	}

}
