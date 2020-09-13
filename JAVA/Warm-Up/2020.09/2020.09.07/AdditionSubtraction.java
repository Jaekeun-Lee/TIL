
public class AdditionSubtraction {

	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int result;
		
		if(num1>num2) {
			result = num1-num2;
			System.out.println("첫번째 인수 :"+num1+" / 두번째 인수 :"+num2+"\n"
					+ num1+" - "+num2+" = "+result);
		}else {
			result = num1+num2;
			System.out.println("첫번째 인수 :"+num1+" / 두번째 인수 :"+num2+"\n"
					+ num1+" + "+num2+" = "+result);
		}
	}

}
