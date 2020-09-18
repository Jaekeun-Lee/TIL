public class TryCatchTest {

	public boolean solution(String s) {
		if(s.length()==4||s.length()==6) {
			try {
				Integer.parseInt(s);
				return true;
			}
			catch(NumberFormatException e) {
				return false;
			}
		}else return false;
	}
	public static void main(String[] args) {
		String s1 = "a234";
		String s2 = "1234";
		
		System.out.println(new TryCatchTest().solution(s1));
		System.out.println(new TryCatchTest().solution(s2));
		
	}

}
