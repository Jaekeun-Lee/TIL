package algorithm.sort.insertion;

import algorithm.sort.Sort;

public class InsertionSort extends Sort {

    @Override
    public int[] solution(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minValue = arr[i];
            int prev = i - 1;
            while ((prev >= 0) && arr[prev] > minValue) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = minValue;
        }

        return arr;
    }
}
