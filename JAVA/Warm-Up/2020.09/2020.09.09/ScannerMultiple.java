import java.util.Scanner;
public class ScannerMultiple {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 : ");
		
		int inputInt = keyboard.nextInt();
		
		if(1<inputInt && inputInt<10) {
			for(int i =1; i<10;i++) {
				System.out.println(inputInt+" * "+i+" = "+(inputInt*i));
			}
		}
		else System.out.println("잘못된 숫자가 입력 되었습니다.");
		
		keyboard.close();
	}

}
