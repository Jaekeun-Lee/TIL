package algorithm.sort.selection;

import algorithm.sort.Sort;

public class SelectionSort extends Sort {
    @Override
    public int[] solution(int[] arr) {

        int minIndex = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
        return arr;
    }
}
