package algorithm.sort;

import java.util.Arrays;

public abstract class Sort {

    public abstract int[] solution(int[] arr);

    /**
     * 배열 오름차순 정렬
     * @param arr
     * @return String
     */
    final String sort(int[] arr) {

        StringBuilder sb = new StringBuilder();

        sb.append("\n** [ ");
        sb.append(this.getClass().getSimpleName());
        sb.append(" ] =====================================");
        sb.append("\n\t전달 받은 배열 :: ");
        sb.append(Arrays.toString(arr));
        sb.append("\n\t정렬 후의 배열 :: ");
        sb.append(Arrays.toString(this.solution(arr)));

        return sb.toString();
    }


}
