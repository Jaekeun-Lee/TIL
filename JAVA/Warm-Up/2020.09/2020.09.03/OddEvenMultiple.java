public class OddEvenMultiple {

	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		
		int []num = new int[2];

		num[0] = Integer.parseInt(args[0]);
		num[1] = Integer.parseInt(args[1]);
		
		for(int i=0;i<num.length;i++) {
			if(num[i]%2==0) { //짝수일 때
				if(num[i]%3==0) {
					System.out.println("입력하신 "+(i+1)+"번째 인자 값 "+num[i]+"는 짝수이며 3의 배수 입니다.");
				}
				else System.out.println("입력하신 "+(i+1)+"번째 인자 값 "+num[i]+"는 짝수이며 3의 배수가 아닙니다.");
			}
			else if(num[i]%2!=0) {//홀수일 때
				if(num[i]%3==0) {
					System.out.println("입력하신 "+(i+1)+"번째 인자 값 "+num[i]+"는 홀수이며 3의 배수 입니다.");
				}
				else System.out.println("입력하신 "+(i+1)+"번째 인자 값 "+num[i]+"는 홀수이며 3의 배수가 아닙니다.");
			}
			else System.out.println("판단할수없어요");
		}
		
		
		
	}

}
