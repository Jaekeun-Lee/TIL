public class Star {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		
		for(int i = 0; i<=num; i++) {
			for(int j=0; j<num-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<(i*2)-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
