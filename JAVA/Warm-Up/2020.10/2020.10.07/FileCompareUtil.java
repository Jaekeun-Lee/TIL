 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileCompareUtil {

	public ArrayList<String> compareFile(String firstFile, String secondFile) throws Exception {

		ArrayList<String> result = new ArrayList<String>();

		BufferedReader brFirstFile = new BufferedReader(new FileReader(firstFile));
		BufferedReader brSecondFile = new BufferedReader(new FileReader(secondFile));

		int LineNum = 0;
		String firstFileReadLine = null;
		String secondFileReadLine = null;

		while ((firstFileReadLine = brFirstFile.readLine()) != null && (secondFileReadLine = brSecondFile.readLine()) != null) {
			if (!firstFileReadLine.equals(secondFileReadLine)) {
				result.add("Line " + (LineNum + 1) + " : " + secondFileReadLine);
			}
			LineNum++;
		}
		
		brFirstFile.close();
		brSecondFile.close();

		return result;
	}

	public static void main(String[] args) throws Exception {

		FileCompareUtil util = new FileCompareUtil();
		System.out.println(util.compareFile("./files/firstFile.txt", "./files/secondFile.txt").toString());
		System.out.println("Successful!");
		
	}

}
