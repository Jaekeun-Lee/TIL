 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class FileController {

	public void reverseLine(String oldFile, String newFile) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(oldFile));
		Stack<String> temp = new Stack<String>();

		String s = "";
		while ((s = br.readLine()) != null) {
			temp.push(s);
		}

		br.close();

		BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
		while (!temp.isEmpty()) {
			bw.write(temp.pop());
			bw.newLine();
		}

		bw.flush();
		bw.close();

	}

	public static void main(String[] args) throws Exception {

		new FileController().reverseLine("files/oldfile.txt", "files/newfile.txt");

	}

}
