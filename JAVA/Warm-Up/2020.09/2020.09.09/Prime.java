public class Prime {

	public static void main(String[] args) {

		int limit = 50;
		boolean prime = false;

		for(int i = 2; i <=limit;i++) {
			prime=false;
			for(int j = 2; j < i; j++) {
				if ( i % j == 0) {
					prime=true;
					break;
				}
			}
			if(prime==false) {
				System.out.println(i);
			}
		}
		
		/*
		//while¹®
		int i = 2;
		while (i <= limit) {
			prime = false;

			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					prime = true;
					break;
				}
				continue;
			}

			if (prime == false) {
				System.out.println(i);
			}
			i++;

		}
		*/
		
	}
}
