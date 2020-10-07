package iopractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Grade {

	public void printGrade(String fileName) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		// HashMap은 저장 순서를 보장하지 않음, LinkedHashMap을 이용하여 입력 순서대로 저장
		HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		StringBuilder printStr = new StringBuilder();

		int sum = 0;
		String s = null;

		// LinkedHashMap저장 방법1. StringTokenizer 사용

		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s, ",");
			// 받은 문자열 분리해서 키=이름 / 값=점수로 형변환 저장
			map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		
		
	/*
		// LinkedHashMap저장 방법2. String 배열로 분리한 문자열 받아서 사용
		
		int index = 0;
		String[] splitStr = new String[2];

		while ((s = br.readLine()) != null) {

			splitStr = s.split(",");
			// 받은 문자열 분리해서 키=이름 / 값=점수로 형변환 저장
			map.put(splitStr[index], Integer.parseInt(splitStr[index + 1]));
			index = 0;

		}
	*/
		
		// map 전체 내용 출력
		// System.out.println(map.toString());

		// 개인점수 출력
		for (Entry<String, Integer> entry : map.entrySet()) {
			printStr.append(entry.getKey());
			printStr.append("의 점수는 ");
			printStr.append(entry.getValue());
			printStr.append("점 입니다. \n");
			sum+=entry.getValue();
		}
		
		//총점수 , 평균점수 출력
		printStr.append("모두의 총점은 ");
		printStr.append(sum); 
		printStr.append("점 입니다.\n모두의 평균은 "); 
		printStr.append(sum/map.size());
		printStr.append("점 입니다."); 
		
		System.out.println(printStr.toString());
		br.close();
	}

	public static void main(String[] args) {

		String path = "score.txt";

		try {

			new Grade().printGrade(path);

		} catch (FileNotFoundException e) {
			// printGrade()에서 받은 FileNotFoundException 예외 처리 구간
			try {

				// 파일이 존재하지 않으면 path로 받은 경로에 파일 생성
				new File(path).createNewFile();
				BufferedWriter creater = null;

				try {
					creater = new BufferedWriter(new FileWriter(path));

					creater.write("홍길동,50\n");
					creater.write("둘리,60\n");
					creater.write("도우너,90\n");
					creater.write("철수,100\n");
					creater.flush();

				} catch (IOException e1) {
					e1.printStackTrace();

				} finally {
					creater.close();
				}

				System.out.println("파일 생성 후 실행 되었습니다! 다시 실행해주세요!! \n");

			} catch (IOException e2) {
				System.out.println("파일 생성 중 문제가 발생했습니다!");
				e2.printStackTrace();
			}

		} catch (Exception e3) {
			// printGrade()에서 받은 기타 예외 처리
			e3.printStackTrace();

		}

		
	}// end of main

	
}// end of file
