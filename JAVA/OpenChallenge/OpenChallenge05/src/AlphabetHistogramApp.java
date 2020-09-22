import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetHistogramApp {
	int histoData [] = new int [26]; // 영어 알파벳 26자를 카운팅하는 정수형 배열
	StringBuffer sb = new StringBuffer(); // 키 입력을 받을 스트링 버퍼
	
	public AlphabetHistogramApp() {
		for(int i=0; i<histoData.length; i++)
			histoData[i] = 0; // 초기에 카운팅 값을 모두 0으로 설정
	}
	
	// 키보드로부터 알파벳 문자를 읽고 히스토그램을 그리는 핵심 메소드
	public void run() {
		readString();
		makeHistogram();
		drawHistogram();
	}
	
	// 입력받은 문자들로부터 히스토그램의 데이타를 만든다.
	public void makeHistogram() {
		String s = sb.toString(); // 스트링 버퍼의 문자열을 스트링으로 리턴
		s = s.toUpperCase(); // 스트링을 모두 소문자로 변경

		// 입력된 모든 문자를 비교하여 히스토 데이타를 만든다.
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') { // 알파벳 문자만 카운팅
				int index = c - 'A';
				histoData[index]++;
			}
		}		
	}

	// 히스토그램을 그린다.
	public void drawHistogram() {
		System.out.println("\n히스토그램을 그립니다.");
		for(int i =0; i<histoData.length; i++) {
			System.out.print((char)('A'+ i)); //대문자를 출력한다.

			for(int j=0; j<histoData[i]; j++)
				System.out.print('-'); // 히스토데이타 개수만큼 -를 출력한다.
			System.out.println();			
		}
	}
	
	// 키보드로부터 문자열을 읽어 스트링 버퍼에 저장한다.
	public void readString() {
		InputStreamReader rd = new InputStreamReader(System.in);
		try {
			while (true) {
				int c = rd.read(); //Ctrl-z가 입력되면 -1을 리턴한다.
				if (c == -1) 	
					break;
				sb.append((char)c); // 읽은 문자를 스트링 버퍼에 추가한다.
			} 
		}
		catch (IOException e) {
			System.out.println("입력 에러 발생");
		}
	}
	
	public static void main(String[] args) {
		AlphabetHistogramApp app = new AlphabetHistogramApp();
		app.run();
	}

}
