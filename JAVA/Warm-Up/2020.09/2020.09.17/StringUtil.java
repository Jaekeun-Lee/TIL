
public class StringUtil {

	private static String replaceString(String[] arr) {

		int cnt = 0;
		int maxcnt = 1;
		String str ="";

		// 배열 하나씩 탐색 후 a가 가장 많이 들어간 인덱스 maxcnt에 저장
		for (int i = 0; i < arr.length; i++) {
			if (cnt > maxcnt) {
				maxcnt = i-1;
			}
			cnt = 0;
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == 'a') {
					cnt++;
				}
			}
		}
		
		// a ==> A로 변경
		for (int i = 0; i < arr[maxcnt].length(); i++) {
			str += (arr[maxcnt].charAt(i)=='a')? 'A': arr[maxcnt].charAt(i);
		}

		// String.replace() 사용
		//return arr[maxcnt].replace('a', 'A');
		
		return str;
	}

	public static void main(String[] args) {
		String[] arr = { "java program", "array", "java program area", "append"};
		String result = StringUtil.replaceString(arr);
		System.out.println("변경된 문자열 ==> " + result);
	}

}
