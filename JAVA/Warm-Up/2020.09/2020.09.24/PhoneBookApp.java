import java.util.*;
    
public class PhoneBookApp {
	// 메뉴 번호를 위한 상수를 정의한다.
	final int INSERT = 0;
	final int DELETE = 1;
	final int SEARCH = 2;
	final int SHOWALL = 3;
	final int EXIT = 4;		
	
	private Scanner scanner;
	private HashMap<String, Phone> map = new HashMap<String, Phone>();
		
	public PhoneBookApp() {
		scanner = new Scanner(System.in);		
	}
	
	 // 전화번호 관리 메소드
	public void run() {
		System.out.println("-------------------------------------------------");
		System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장하지 않습니다.");
		System.out.println("-------------------------------------------------");
		while(true) {
			System.out.print("삽입:0. 삭제:1, 찾기:2, 전체보기:3, 종료:4>>");
			int menu = readNumber();
			switch(menu) {
				case INSERT: insert(); break;
				case DELETE: delete(); break;
				case SEARCH: search(); break;
				case SHOWALL: showAll(); break;	
				case EXIT: 	System.out.println("프로그램을 종료합니다..."); return;					
				default: System.out.println("입력이 틀렸습니다. 다시 입력하세요."); continue;
			}
		}	
	}
	
	// 삽입 메뉴를 구현하며 하나의 전화 번호 레코드를 저장한다.
	private void insert() {
		System.out.print("이름>>");
		String name = scanner.next();
		if(map.get(name)!=null) {
			System.out.println("이미 존재하는 사람입니다.");
			return;
		}
		
		System.out.print("주소>>");
		String address = scanner.next();
		System.out.print("전화번호>>");
		String telNum = scanner.next();		
		
		// 해쉬 테이블에 삽입
		map.put(name, new Phone(name, address, telNum));
	}
	
	// 삭제 메뉴를 구현하며 하나의 전화 번호 레코드를 삭제한다.
	private void delete() {
		System.out.print("이름>>");
		String name = scanner.next();
		Phone p = map.remove(name); // 해쉬 테이블에서 삭제
		if(p == null)
			System.out.println(name +"는 등록되지 않은 사람입니다.");
		else {
			System.out.println(name+"은 삭제되었습니다.");
		}
	}
	
	// 찾기 메뉴를 구현하며 하나의 전화 번호 레코드를 검색한다.
	private void search() {
		System.out.print("이름>>");
		String name = scanner.next();
		Phone p = map.get(name); // 해쉬테이블에서 검색
		if(p == null)
			System.out.println(name +"는 등록되지 않은 사람입니다.");
		else
			System.out.println(p.toString());
	}
	
	// 전체보기 메뉴를 구현한다.
	private void showAll() {
		Set<String> keys = map.keySet(); // key 문자열을 가진 집합 Set 컬렉션 리턴
		Iterator<String> it = keys.iterator(); // key 문자열을 순서대로 접근할 수 있는 Iterator 리턴
		while(it.hasNext()) {
			String name = it.next();
			Phone p = map.get(name);
			System.out.println(p.toString());
		}
	}
	
	private int readNumber() {
		int n=-1;
		try {
			n = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			return -1;
		}
		return n;
	}

	public static void main(String args[]) {
		PhoneBookApp pb = new PhoneBookApp();
		pb.run();
	}
}

// 하나의 전화 번호 정보를 가지는 클래스
class Phone {
	private String name; // 이름
	private String address; // 주소
	private String telNum; // 전화 번호
	
	public Phone(String name, String address, String telNum) {
		this.name = name;
		this.address = address;
		this.telNum = telNum;
	}
	
	public String getName() {return name;}
	public String getAddress() {return address;}
	public String getTelNum() {return telNum;}	
	
	public String toString() {
		return name + " " + address + " " + telNum;
	}
}
