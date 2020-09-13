class StringArrayMultiple
{
	public static void main(String[] args) 
	{
		String [][] text = new String[9][9];

		for (int i = 0; i<text.length ;i++ )
		{
			System.out.println((i+1)+"단을 출력합니다.");
			for (int j = 0; j<text[i].length ;j++ )
			{
				text[i][j] = String.valueOf((i+1)*(j+1));
				System.out.println( (i+1)+" * "+(j+1)+" = " + text[i][j]);
			}
			System.out.println("-------------------");
		}

	}
}
/*

1. length는 배열의 길이를 알고자 할때 사용된다.
2. length()는 문자열의 길이를 알고자 할때 사용된다.

 */