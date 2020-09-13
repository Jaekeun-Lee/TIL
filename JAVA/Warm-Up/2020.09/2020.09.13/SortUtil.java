import java.util.Scanner;
public class SortUtil {


	public static void main(String[] args) {

		Sorting sorting = new Sorting();
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
			int[] numbers = new int[] { 7, 5, 2, 19, 34, 51, 32, 11, 67, 21 };
			System.out.println(" \n\n================================================================================================\n");
			System.out.print("\t 1.선택정렬 \t 2.버블정렬 \t 3.삽입정렬 \t 4.Arrays.sort()      종료 : -1 \n");
			System.out.println(" \n================================================================================================\n");
			System.out.print("정렬할 배열의 원소들 : [ ");
			for (int a : numbers) {
				System.out.print(a + "  ");
			}
			System.out.print("]\n\n정렬 알고리즘 선택 : ");
			int inputNum = sc.nextInt();

			switch (inputNum) {
			
			// 1. Selection Sort
			case 1:		
				sorting.selectionSort(numbers);
				break;

			//2. Bubble Sort
			case 2:		
				sorting.bubbleSort(numbers);
				break;

			//3. Insertion Sort
			case 3:		
				sorting.insertionSort(numbers);
				break;
			
			//4. Arrays.sort 정렬함수
			case 4:
				sorting.ascending(numbers);
				break;
			}
			if (inputNum == -1) {
				System.out.println("프로그램이 종료되었습니다.");
				sc.close();
				break;

			}
		
	}

	}}
