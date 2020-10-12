package iopractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class Completion {

	public Vector<String> getList() throws Exception {

		Vector<String> result = new Vector<String>();
		BufferedReader br = null;
		String filePath = "./src/iopractice/list.txt";
		String line = null;

		br = new BufferedReader(new FileReader(filePath));

		while ((line = br.readLine()) != null) {
			String[] temp = line.split("/");

			for (String s : temp) {
				result.add(s);
			}

			if (temp[1].toUpperCase().equals("JAVA") && Integer.parseInt(temp[2]) >= 80
					|| temp[1].toUpperCase().equals("SQL") && Integer.parseInt(temp[2]) >= 90) {
				result.add("수료");
			} else {
				result.add("미수료");
			}

		}

		br.close();
		return result;
	}

	public static void main(String[] args) throws Exception {
		Vector<String> scores = new Completion().getList();
		for (int start = 0, end = 4; end <= scores.size(); start += 4, end += 4) {
			System.out.println(scores.subList(start, end));
		}
	}

}
