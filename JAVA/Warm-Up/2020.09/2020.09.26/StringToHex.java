
public class StringToHex {

	public static String toEncoding(String s) {

		StringBuffer sb = new StringBuffer();
		byte[] temp = s.getBytes();

		for (int i = 0; i < temp.length; i++) {
			if(Integer.toHexString(temp[i]).length()>7) {
				sb.append("%" + Integer.toHexString(temp[i]).substring(6, 8).toUpperCase());
			}
			else sb.append((char) temp[i]);
		}

		String answer = sb.toString();
		return answer;
	}

	public static void main(String[] args) throws Exception {
		String str = "È« ±æµ¿ abc AºñC 0319 9.2";
		System.out.println(StringToHex.toEncoding(str));

	}

}
