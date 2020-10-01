
public class CellPhoneMain {

	public static void main(String[] args) {

		CellPhone myPhone = new CellPhone("SCH-600");

		myPhone.charge(20);
		myPhone.printBattery();

		myPhone.call(300);
		myPhone.printBattery();

		myPhone.charge(50);
		myPhone.printBattery();

		myPhone.call(40);
		myPhone.printBattery();

		try {
			myPhone.call(-20);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		CellPhone yourPhone = new CellPhone("SCH-600");

		if (myPhone.equals(yourPhone)) {
			System.out.println("동일 모델 입니다.");
		} else {
			System.out.println("다른 모델 입니다.");
		}

	}

}
