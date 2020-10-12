package iopractice;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class RandomNumUtil implements AutoCloseable{

	// 10개의 난수 생성하여 배열로 리턴
	private static int[] generateRandomNumber() {

		// 난수 알고리즘을 실행하기 위해 쓰는 수 = Seed
		// Seed를 현재시간으로 설정하여 생성
		Random rand = new Random(System.currentTimeMillis());

		int[] randomNumArr = new int[10];

		for (int i = 0; i < randomNumArr.length; i++) {
			randomNumArr[i] = rand.nextInt(20) + 1; // 0부터 19까지 나오니까 +1해서 저장
			if (i > 0) { // 중복값 비교
				for (int j = 0; j < i; j++) {
					if (randomNumArr[i] == randomNumArr[j]) {
						i--; // 중복되면 다시받음
					}
				}
			}
		}

		return randomNumArr;
	}

	// 발생된 난수와 통계정보를 store.txt 파일에 출력
	public static void printStatistics(int[] array) {
		
		// 1.try-with-resource
		try(BufferedWriter bw= new BufferedWriter(new FileWriter("store2.txt"))){
			double sum = 0;
			for (int a : array) {
				sum += a;
				bw.write(a + "");
				bw.newLine();
			}

			Arrays.sort(array);

			bw.write("최대값 : " + array[array.length - 1] + "\n");
			bw.write("최소값 : " + array[0] + "\n");
			bw.write("평균값 : " + sum / array.length + "\n");
		}catch(IOException e){
	        e.printStackTrace(); 
	    }
		
/*
		// 2.try-catch-finally
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter("store.txt"));
			double sum = 0;
			for (int a : array) {
				sum += a;
				bw.write(a + "");
				bw.newLine();
			}

			Arrays.sort(array);

			bw.write("최대값 : " + array[array.length - 1] + "\n");
			bw.write("최소값 : " + array[0] + "\n");
			bw.write("평균값 : " + sum / array.length + "\n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
*/
	}
	@Override
	public void close() throws Exception {

	}
	
	public static void main(String[] args) {

		int[] array = generateRandomNumber();
		printStatistics(array);
		System.out.println("Successfully Save !");

	}

	

}
