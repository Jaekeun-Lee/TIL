
public class WhileTest {

	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			System.out.println("While 내부 print i=" + i);
			i++;
		}

		int j = 0; // 순환문의 조건을 주기위한 j초기화
		do {
			System.out.println("\n\tdo문 내부 j=" + j);
			j++; // 증감식
		} while (j < 1);// 조건(boolean data type)

		System.out.println("===================");

		int k = 1;
		while (k < 10) {
			System.out.println("5 * " + k + " = " + 5 * k);
			k++;
		}

		// while(true) { System.out.println("무한루프"); }
	}

}
