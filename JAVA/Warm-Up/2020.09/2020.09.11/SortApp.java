import java.util.Scanner;

/*

 1. 선택정렬 (SelectionSort) : 전체 원소들 중에서 기준 위치에 맞는 원소를 선택하여 자리를 교환하는 방식
 2. 버블 정렬(BubbleSort) : 인접한 두개의 원소를 비교하여 자리를 교환하는 방식으로 정렬 (간단하지만 정렬이 끝나도 계속 비교한다는 단점)
 3. 삽입 정렬(InsertSort) : 정렬되어 있는 부분집합에 새로운 원소의 위치를 찾아 삽입하는 정렬방식
 
 */

public class SortApp {

	public static int size;
	// 선택정렬 ( SelectionSort )
	private static void selectionSort(int[] arr) {
		// 지역변수
		int min;
		int temp;
		size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;

			System.out.print((i + 1) + "차 수행 결과 = [ ");
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println("]");
		}

		System.out.println("\n선택 정렬을 완료하였습니다.");
		System.out.print("==> 정렬된 배열 = [ ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("]");
		System.out.println("\n=======================================");
	}

	private static void bubbleSort(int[] arr) {

		int temp;
		size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 1; j < size - i; j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
			System.out.print((i + 1) + "차 수행 결과 = [ ");
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println("]");
		}

		System.out.println("\n선택 정렬을 완료하였습니다.");
		System.out.print("==> 정렬된 배열 = [ ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("]");
		System.out.println("\n=======================================");

	}

	private static void insertSort(int[] arr) {
		int temp;
		size = arr.length;
		for (int i = 1; i < size; i++) {
			int j = i;
			temp = arr[i];
			while ((j > 0) && (arr[j - 1] > temp)) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
			System.out.print(i + "차 수행 결과 = [ ");
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println("]");
		}
		System.out.println("\n선택 정렬을 완료하였습니다.");
		System.out.print("==> 정렬된 배열 = [ ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("]");
		System.out.println("\n=======================================");

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int[] arr = { 3, 24, 1, 55, 17, 43, 5 };
			System.out.print("1.선택정렬\t2.버블정렬\t3.삽입정렬\t | 종료:-1 \n");
			System.out.print("정렬할 배열의 원소들 : [ ");
			for (int a : arr) {
				System.out.print(a + "  ");
			}
			System.out.print("]\n정렬 알고리즘 선택 : ");
			int inputNum = sc.nextInt();

			switch (inputNum) {
			case 1:
				selectionSort(arr);
				break;

			case 2:
				bubbleSort(arr);
				break;

			case 3:
				insertSort(arr);
				break;
			}
			if (inputNum == -1) {
				System.out.println("프로그램이 종료되었습니다.");
				sc.close();
				break;

			}

		} // while

	}// main
}
