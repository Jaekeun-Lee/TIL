 
public class Account {

	/// Field
	private String accountNo;
	private boolean creditLine;
	private int creditLineLimit; // 마이너스 금액한도
	private int balance;

	/// Constructor
	public Account() {
		super();
		this.accountNo = null;
		this.creditLine = false;
		this.creditLineLimit = 0;
		this.balance = 0;
	}

	public Account(String accountNo, boolean creditLine, int creditLineLimit, int balance) {
		super();
		this.accountNo = accountNo;
		this.creditLine = creditLine;
		this.creditLineLimit = -creditLineLimit;
		this.balance = balance;
	}

	/// Method
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public boolean isCreditLine() {
		return creditLine;
	}

	public void setCreditLine(boolean creditLine) {
		this.creditLine = creditLine;
	}

	public int getCreditLineLimit() {
		return creditLineLimit;
	}

	public void setCreditLineLimit(int creditLineLimit) {
		this.creditLineLimit = -creditLineLimit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int money) {
		this.balance += money;
	}

	public void withdraw(int money) throws Exception {
		// 마이너스 통장
		if (creditLine) {
			if ((this.balance -= money) < this.creditLineLimit) {
				throw new Exception("잔고가 부족하여 출금이 불가능합니다.");
			}

			// 마이너스 통장 X
		} else {
			if ((this.balance -= money) < 0) {
				throw new Exception("잔고가 부족하여 출금이 불가능합니다.");
			}
		}
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		if (this.accountNo == null) {
			builder.append("계좌 설정이 필요합니다.");
		} else {
			builder.append("계좌 번호 : ");
			builder.append(this.accountNo);
			builder.append(", 잔고 : ");
			builder.append(this.balance);
			builder.append("원");
			if (this.creditLine) {
				builder.append("\t[[ ");
				builder.append(this.creditLineLimit);
				builder.append("원 마이너스 통장입니다. ]]");
			}
		}
		return builder.toString();
	}

}
