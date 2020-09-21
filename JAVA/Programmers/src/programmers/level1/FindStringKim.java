package programmers.level1;

public class FindStringKim {

	public static int findKim(String[] list) {

		int index = 0;
		for (int i = 0; i < list.length; i++) {
			index = list[i].equals("Kim") ? i : -1;
		}
		return index;
	}

	public static void main(String[] args) {
		String[] list = { "Jane", "Steve", "Kim" };

		System.out.println("김서방은 "+findKim(list)+"에 있다.");
	}

}
