package algorithm.binarysearch;

/**
 * - 여러 개의 수가 정렬된 순서로 있을 때 특정한 수를 찾는 방법
 * - 단순 반복문을 이용하면 수의 개수에 따라 비교 횟수가 증가하는 O(n)의 수행이 이루어짐
 * - 수가 정렬된 상태에서는 이진 탐색(binary search)을 활용하면 매번 비교되는 요소의 수가 절반으로 감소될 수 있으므로 O(logN)의 수행으로 원하는 수를 찾을 수 있음
 * - 83의 위치를 찾아보세요
 */
public class BinarySearchProblem {

    // 이진탐색 함수 solution
    public int solution(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (numbers[mid] == target) {
                return ++mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else if (numbers[mid] > target) {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }


        return -1;
    }

    // 테스트를 위한 코드
    public static void main(String[] args) {

        int[] numbers = {12, 25, 31, 48, 54, 66, 70, 83, 95, 108};
        int target = 108;

        int result = new BinarySearchProblem().solution(numbers, target);
        if (result > 0) {
            System.out.println("찾는 수는 " + result + "번째 있습니다.");
        } else {
            System.out.println("찾는 수는 배열에 없습니다.");
        }
    }
}
