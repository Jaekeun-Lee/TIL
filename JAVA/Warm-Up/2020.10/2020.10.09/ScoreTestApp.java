package iopractice.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Vector;
import iopractice.Score;

public class ScoreTestApp {

	public List<Score> getScore(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		List<Score> studentScore = new Vector<Score>();

		String line = null;
		while ((line = br.readLine()) != null) {
			String[] strArr = line.split("/");

			String name = strArr[0];
			int korScore = Integer.parseInt(strArr[1]);
			int engScore = Integer.parseInt(strArr[2]);
			int mathScore = Integer.parseInt(strArr[3]);
			int sumScore = korScore + engScore + mathScore;

			studentScore.add(new Score(name, korScore, engScore, mathScore, sumScore));

		}

		br.close();
		return studentScore;
	}

	public static void main(String[] args) {

		ScoreTestApp app = new ScoreTestApp();
		try {
			
			List<Score> scores = app.getScore("src/bitcamp1007/data.txt");
			//StringBuilder sb = new StringBuilder();
			
			System.out.println(String.format("%s\t%s\t%s\t%s\t| %s", "이름", "국어","영어","수학","총점"));
			for (Score student : scores) {
				
				System.out.println(String.format("%s\t%d\t%d\t%d\t| %d점", student.getName(), student.getKor(),student.getEng(),student.getMath(),student.getSum()));
				
				/*
				sb.append(student.getName());
				sb.append(" : ");
				sb.append(student.getKor());
				sb.append(" ");
				sb.append(student.getEng());
				sb.append(" ");
				sb.append(student.getMath());
				sb.append(" ");
				sb.append(student.getSum());
				sb.append("\n");
				*/
			}

			//System.out.println(sb);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
