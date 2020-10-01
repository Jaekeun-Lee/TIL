
public class FindCharacters {

	public int countChar(String targetStr, char word) {
		int count = 0;
		
		for (int i = 0; i < targetStr.length(); i++) {
			if(targetStr.charAt(i)==word) {
				count++;
			}
		}
		
		
		
		return count;
	}

	public static void main(String[] args) {
		FindCharacters fc = new FindCharacters();
		int count = fc.countChar("Boys, be ambitious", 'i');
		System.out.println(count);

	}

}
