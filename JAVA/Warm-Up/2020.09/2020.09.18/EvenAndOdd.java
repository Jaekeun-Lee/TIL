package programmers.level1;

public class EvenAndOdd {
	public String solution(int num) {
        String answer = "";
        answer+=(num%2==0)?"Even":"Odd";
        return answer;
    }
	public static void main(String[] args) {
		EvenAndOdd ss = new EvenAndOdd();
		
		String a = ss.solution(3);
		System.out.println(a);
		

	}

}
