
public class ArgsString {

	public static void main(String[] args) {
		String name = args[0];		//이름
		String hp = args[1];			//전화번호

		System.out.println("==========================================");
		System.out.println("출력결과");
		
		System.out.println("\n이름은 \""+name+"\"입니다.");
		System.out.println("\"" + name + "\"씨의 [hp]는 " + "\"" + hp + "\" 입니다 ");

		System.out.println("==========================================");
	}

}
