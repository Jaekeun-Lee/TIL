
/*
 * 추상 메소드 / 추상클래스의 필요성 및 이해
 * 
 * 추상메소드
 * - 구체적일 필요가 없는 메소드
 * - 하위 클래스에서 구체적으로 재정의(오버라이딩)해야 강제성을 갖는 메소드
 * 
 * 추상 클래스
 * - 구체적이지 않은 추상 메소드가 정의된 클래스
 * - 일반화의 관계중 공통적, 일반적 행위와 속성을 공유할 목적으로 정의된 클래스
 * ==> 추상클래스는 인스턴스 생성을 할 수 없다!!!!!!!!!!!!!!! <==
 * 
 * */

abstract class BusCharge {
	/// Field
	String section;
	
	/// Constructor
	public BusCharge() {

	}

	public BusCharge(String section) {
		this.section = section;
	}

	/// Method
	public void information() {
		System.out.println("버스요금 안내");
	}

	// 하위 클래스에 오버라이딩을 강제하는 추상메서드를 정의한다.
	public abstract void charge();
}

//abstract class상속시 abstract method를 필히 재정의(오버라이딩)해야한다.
class Student extends BusCharge {
	public Student() {
		super("학생");
	}

	// 이 함수가 없으면 추상클래스 상속 되지않는다.
	// 추상클래스를 상속하려면 추상메소드를 무조건 오버라이딩해야한다!!!!!!!!!!!!!!!!!!!!!!
	public void charge() {
		System.out.println("::300원");
	}
}

//abstract class상속시 abstract method를 필히 재정의(오버라이딩)해야한다.
class Adult extends BusCharge {
	public Adult() {
		super("일반인");
	}

	// 이 함수가 없으면 추상클래스 상속 되지않는다.
	// 추상클래스를 상속하려면 추상메소드를 무조건 오버라이딩해야한다!!!!!!!!!!!!!!!!!!!!!!
	public void charge() {
		System.out.println("::500원");
	}
}

//abstract class상속시 abstract method를 필히 재정의(오버라이딩)해야한다.
class Old extends BusCharge {
	public Old() {
		super("노인");
	}

	// 이 함수가 없으면 추상클래스 상속 되지않는다.
	// 추상클래스를 상속하려면 추상메소드를 무조건 오버라이딩해야한다!!!!!!!!!!!!!!!!!!!!!!
	public void charge() {
		System.out.println("::공짜");
	}
}

public class Display {

	public static void main(String[] args) {
		/*
		 
		Student b1 = new Student();
		Adult b2 = new Adult();
		Old b3 = new Old();

		b1.information();
		System.out.print(b1.section);
		b1.charge();//어떤 클래스의 메소드가 호출되었는지 확인
		
		b2.information();
		System.out.print(b2.section);
		b2.charge();//어떤 클래스의 메소드가 호출되었는지 확인
		
		b3.information();
		System.out.print(b3.section);
		b3.charge();//어떤 클래스의 메소드가 호출되었는지 확인
		
		//추상클래스는 객체 생성이 불가하다.
		//BusCharge bc01=new BusCharge();
		
		//객체 생성은 불가능하지만 변수의 선언(데이터타입)은 가능하다.
		//BusCharge bc02;
		 
		 
		*/
		
		
		//상위 레퍼런스로 하위 인스턴스를 참조가능(묵시적 형변환) is~a관계
		BusCharge bc1=new Student();
		BusCharge bc2=new Adult();
		BusCharge bc3=new Old();
		//==> Polymorphism : 하나의 인터페이스로 접근 및 다양한 활용
		
		bc1.information();
		System.out.print(bc1.section);
		bc1.charge();
		
		bc2.information();
		System.out.print(bc2.section);
		bc2.charge();
		
		bc3.information();
		System.out.print(bc3.section);
		bc3.charge();
		
		System.out.println("=======================");
		
		BusCharge[] bc = new BusCharge[3];
		bc[0]=new Student();
		bc[1]=new Adult();
		bc[2]=new Old();
		
		for(int i=0;i<bc.length;i++) {
			bc[i].information();
			System.out.println(bc[i].section);
			bc[i].charge();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
