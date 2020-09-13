
public class Sum {

	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int sum=0;
		int temp;
		

		if (num1>num2){

			temp = num1;
			num1=num2;
			num2=temp;
			
		}
		else if (num1==num2){
			System.out.println("입력 값이 같습니다 \n[usage]:: 두 숫자를 다르게 입력해주세요.");
			//System.exit(0); // C언어의 return 0과 같은 기능
			return;
		}

		for(int i =num1;i<=num2;i++) {
			sum+=i;
		}
		System.out.println(num1+" ~ "+num2+"까지의 합계 : "+sum);

	}

}
