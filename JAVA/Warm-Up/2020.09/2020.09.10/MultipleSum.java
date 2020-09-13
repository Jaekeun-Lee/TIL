
import java.util.Scanner;
public class MultipleSum{

	public static void main(String[] args) {
		
		int number = 0;
		int count = 0;
		int sum = 0;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("1~1000사이의 양의 정수를 입력해주세요 : ");
		number = keyboard.nextInt();
		
		for(int i=number;i<=1000;i+=number) {
			sum+=i;
			count++;
		}
		
		System.out.println("============================\n1~1000 사이에서 결과 값 도출 완료");
		System.out.println(number+"의 배수 개수 = "+count);
		System.out.println(number+"의 배수 합 = "+sum);
	
		keyboard.close();
	}

}
