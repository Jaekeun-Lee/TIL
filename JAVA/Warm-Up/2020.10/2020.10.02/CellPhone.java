
public class CellPhone {

	/// Field
	String model;
	double battery;

	/// Constructor
	public CellPhone() {
	}

	public CellPhone(String model) {
		super();
		this.model = model;
	}

	/// Method
	public void call(int callingTime) throws IllegalArgumentException {

		if (callingTime < 0) {
			throw new IllegalArgumentException("입력값 : " + callingTime + " ==> 통화 시간 입력 오류");
		} else {
			// 통화 시간 출력
			System.out.println("통화시간 : " + callingTime + "분");

			// 배터리 감소 ( 통화시간*0.5 , but 0보다 작아지진 않는다. )
			this.battery = (this.battery - callingTime * 0.5 > 0) ? this.battery - callingTime * 0.5 : 0;
		}

	}

	public void charge(int chargingTime) throws IllegalArgumentException {

		if (chargingTime < 0) {
			throw new IllegalArgumentException("입력값 : " + chargingTime + " ==> 충전 시간 입력 오류");
		} else {
			// 충전 시간 출력
			System.out.println("충전시간 : " + chargingTime + "분");

			// 배터리 충전 ( 배터리=충전시간 * 3, but 100보다 커지진 않는다. )
			this.battery = (this.battery + chargingTime * 3 <= 100) ? this.battery + chargingTime * 3 : 100;
		}
	}

	public void printBattery() {
		System.out.println("남은 배터리량 : " + (int)this.battery +"%");
	}

	public boolean equals(Object otherObject) {

		if (!(otherObject instanceof CellPhone)) {
			return false;
		} else {
			return model.equals(((CellPhone) otherObject).model);
		}

	}

}
