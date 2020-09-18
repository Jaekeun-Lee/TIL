//정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

package programmer;

public class Average {
	public double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
        	sum += arr[i];
        }
        answer = sum/arr.length;
        return answer;
    }
	
	public static void main(String[] args) {
		Average av = new Average();
		int [] test = {1,2,3,4};
		int [] test2 = {5,5};

		System.out.println("test : "+av.solution(test));
		System.out.println("test2 : "+av.solution(test2));
	}

}
