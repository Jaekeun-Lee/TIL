 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class FileUtil {
	public static void fileToPrint(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(":: " + line);
		}

		br.close();
	}

	public static Vector<User> fileFindAddress(String fileName, String address) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		Vector<User> vc = new Vector<User>();
		User user = null;
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.contains(address)) {
				String[] temp = line.split("/");
				if (temp[3].equals("³²")) {
					user = new User(temp[0], temp[1], temp[2], true);
				} else {
					user = new User(temp[0], temp[1], temp[2], false);
				}

				vc.add(user);
			}
		}
		
		br.close();
		
		return vc;
	}
}
