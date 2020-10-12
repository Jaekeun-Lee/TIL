 
import java.util.Vector;

public class CusotmerInfoSearch {

	public static void main(String[] args) throws Exception {
		String pathName = "data.txt";
		
		FileUtil.fileToPrint(pathName);
		
		
		
		//data.txt 내용중 서울 거주자 검색, 결과를 담은 vector Instance 받기
		System.out.println("=========================");
		System.out.println("파일 내용중 서울 정보 검색");
		Vector<User> vector = FileUtil.fileFindAddress(pathName, "서울");
		for(User user:vector) {
			System.out.println(user);
		}
		
		System.out.println("=========================");
		System.out.println("파일 내용중 경주 정보 검색");
		vector = FileUtil.fileFindAddress(pathName, "경주");
		for(User user:vector) {
			System.out.println(user);
		}
		
		System.out.println("=========================");
		System.out.println("파일 내용중 경기도 정보 검색");
		vector = FileUtil.fileFindAddress(pathName, "경기도");
		for(User user:vector) {
			System.out.println(user);
		}
	}

}
