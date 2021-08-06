package algorithm.sort;

import algorithm.sort.bubble.BubbleSort;
import algorithm.sort.insertion.InsertionSort;
import algorithm.sort.selection.SelectionSort;

public class Main {
    public static void main(String[] args) {

        Sort selectionSort = new SelectionSort();
        Sort insertionSort = new InsertionSort();
        Sort bubbleSort = new BubbleSort();

        System.out.println(selectionSort.sort(createRandomArray(10)));
        System.out.println(insertionSort.sort(createRandomArray(10)));
        System.out.println(bubbleSort.sort(createRandomArray(10)));
    }

    /**
     * n개의 요소를 가진 난수(1 ~ 99사이의 숫자) 배열 생성
     * @param n
     * @return
     */
    private static int[] createRandomArray(int n) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        return arr;
    }
}
