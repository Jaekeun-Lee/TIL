class  Multiple
{
	public static void main(String[] args) 
	{
		int num = Integer.parseInt(args[0]);
		
		if(0<num && num<10) {
			System.out.println(num+"단을 출력합니다.");
			for (int i=1;i<=9;i++) {
				System.out.println(num+" X "+i+" = "+i*num);
			}
		}
		else {
			System.out.println("1~9사이의 숫자를 입력해주세요.");
		}
	}
}
