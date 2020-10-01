package bill;

public class CellPhone {

	///Field
	private String phoneNumber;
	private int feePerCallTime;
	private int totalCallTime;
	private int totalFee;
	
	
	///Constructor	
	public CellPhone() {
	}
	public CellPhone(String newPhoneNumber, int newFeePerCallTime) {
		this.phoneNumber = newPhoneNumber;
		this.feePerCallTime += newFeePerCallTime;
	}

	
	///Method
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	public int getTotalCallTime() {
		return this.totalCallTime;
	}

	public void setTotalCallTime(int newTotalCallTime) {
		this.totalCallTime = newTotalCallTime;
	}

	public int getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(int newTotalFee) {
		this.totalFee = newTotalFee;
	}

	public int getFeePerCallTime() {
		return this.feePerCallTime;
	}

	public void setFeePerCallTime(int newFeePerCallTime) {
		this.feePerCallTime = newFeePerCallTime;
	}

	
	
	
	public void call(String phoneNumber, int callingTime) {
		System.out.println(phoneNumber+"번호와 " +callingTime + "분 통화했습니다.");
		this.totalCallTime += callingTime;
	}
	
	public void calculationTotalFee() {
		this.setTotalFee(this.totalCallTime *this.feePerCallTime);
	}
	
}
