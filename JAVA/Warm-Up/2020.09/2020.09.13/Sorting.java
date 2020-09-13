import java.util.Arrays;
/*

 1. 선택정렬 (SelectionSort) : 전체 원소들 중에서 기준 위치에 맞는 원소를 선택하여 자리를 교환하는 방식
 2. 버블 정렬(BubbleSort) : 인접한 두개의 원소를 비교하여 자리를 교환하는 방식으로 정렬 (간단하지만 정렬이 끝나도 계속 비교한다는 단점)
 3. 삽입 정렬(InsertionSort) : 정렬되어 있는 부분집합에 새로운 원소의 위치를 찾아 삽입하는 정렬방식
 
 */

 //Bean Class
public class Sorting {

	///Field
	private int size;


	///Method
	protected void selectionSort(int[] arr) {

		int min;
		int temp;
		size = arr.length;

		System.out.println("\n선택 정렬 수행\n\n");
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

	}

	protected void bubbleSort(int[] arr) {
		size = arr.length;
		int temp;

		System.out.println("\n버블 정렬 수행\n\n");
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

		System.out.println("\n버블 정렬을 완료하였습니다.");
		System.out.print("==> 정렬된 배열 = [ ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("]");


	}

	protected void insertionSort(int[] arr) {
		int temp;
		size = arr.length;

		System.out.println("\n삽입 정렬 수행\n\n");
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
		System.out.println("\n삽입 정렬을 완료하였습니다.");
		System.out.print("==> 정렬된 배열 = [ ");
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("]");


	}
	
	public int[] ascending(int[] arr) {
		System.out.println("\n정렬 수행\n\n");
		Arrays.sort(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);

			if (i != arr.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println("");
			}
		}
		System.out.println("\nSuccessful!!!!\n");
		return arr;
	}
}
