
public class ArrayUtil {

	public static char[] reverseString(char[] s, int start, int end) {

		char temp = ' ';

		for (int cnt = 0, i = start, j = end; cnt < ((end + 1) - start) / 2; cnt++, i++, j--) {
			temp = s[j];
			s[j] = s[i];
			s[i] = temp;
		}

		return s;
	}

	public static void main(String[] args) {
		char[] s = { 'J', 'a', 'v', 'a', 'P', 'r', 'o', 'g', 'r', 'a', 'm' };

		System.out.println(ArrayUtil.reverseString(s, 0, 3));
	}

}
