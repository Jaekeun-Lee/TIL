
public class Adder {
	
	public int execute(String expr) {
		
		int result = 0;
		String[] strNum = expr.split("\\+");
		
		for (int i = 0; i < strNum.length; i++) {
			result += Integer.parseInt(strNum[i]);
		}

		return result;
	}
	

	public static void main(String[] args) {
		
		Adder adder = new Adder();
		
		String expr = "3+5+9+1";
		System.out.println(expr + " = " + adder.execute(expr));
		
		expr = "11+45+77+3";
		System.out.println(expr + " = " + adder.execute(expr));

		expr = "33+51+12+11";
		System.out.println(expr + " = " + adder.execute(expr));

	}

}
