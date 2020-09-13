public class Grade {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		String grade = "수우미양가";
		int i;
		
/*
		//if-elseif문
		if (0 < num && num < 101){

			System.out.print("입력하신 값 "+ num +"점은 ");

			if (num >= 90) {
				i=0;
			}
			else if (num >= 80) {
				i=1;
			}
			else if (num >= 70) {
				i=2;
			}
			else if (num >= 60) {
				i=3;
			}
			else {
				i=4;
			}
			System.out.println(grade.charAt(i)+" 입니다");
		}
		
		else System.out.println("1~100점 사이의 점수를 입력해주세요.");

*/

		//switch-case문
		if (0 < num && num < 101){

			System.out.print("입력하신 값 "+num+"점은 ");

			switch (num/10){
				case 10:
				case 9:
					i = 0;
					break;

				case 8:
					i = 1;
					break;

				case 7:
					i = 2;
					break;

				case 6:
					i = 3;
					break;

				default:
					i = 4;
					break;
			}
			System.out.println(grade.charAt(i)+" 입니다");
		} 
		
		else System.out.println("1~100점 사이의 점수를 입력해주세요.");


	}//main
	

}//class

