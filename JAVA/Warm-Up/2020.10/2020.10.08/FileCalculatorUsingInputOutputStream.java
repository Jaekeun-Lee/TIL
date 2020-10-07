package iopractice;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;



//파일에 한자리 숫자만 있을 때 정상 작동하는 App


public class FileCalculatorUsingInputOutputStream {

	public void addCalculateResult(String inputFileName) throws Exception {

		InputStream is = new FileInputStream(inputFileName);
		DataOutputStream os = new DataOutputStream(new FileOutputStream(inputFileName, true));

		byte[] c = new byte[3]; 

		int a = is.read(c); //바이트 배열단위 읽기
		int sum = 0;
		int mul = 1;
		int index = 0;
		while (a != -1) { 			//읽히면 loop
			sum+=(int)c[index]-48;	//바이트로 받은 아스키코드 char형으로 형변환 후 연산
			mul*=(int)c[index]-48;	//바이트로 받은 아스키코드 char형으로 형변환 후 연산
			a = is.read(c);
		}

		//보완점 : 파일에 한자리 숫자만 있을 때만 정상 작동하는 App 
		
		os.writeBytes("\n");
		os.writeBytes(String.valueOf(sum));
		os.writeBytes("\n");
		os.writeBytes(String.valueOf(mul));
		
		is.close();
		os.close();
		
		System.out.println(" Save Success ! ");
	}

	public static void main(String[] args) {
		String path = "./src/bitcamp1007/io/testinputoutputstream.txt";
		try {
			new FileCalculatorUsingInputOutputStream().addCalculateResult(path);
		} catch (Exception e) {
			System.out.println("파일이 없거나 경로 설정을 확인해주세요.");
			e.printStackTrace();
		}
	}

}
