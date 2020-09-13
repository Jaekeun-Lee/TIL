
public class Account {
	
	///Field
	String accNo;
	int balance;
	
	//Constructor
	public Account(String s) {
		this.accNo=s;
		System.out.println(s+" 계좌가 개설되었습니다.");
	}

	///Method
	//입금
	public void deposit(int i) {
		this.balance+=i;
		System.out.println(this.accNo+" 계좌에 "+i+"원이 입금 되었습니다.");
	}
	
	//출금
	public void withdraw(int i) {
		this.balance-=i;
		System.out.println(this.accNo+" 계좌에 "+i+"원이 출금 되었습니다.");
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getAccNo() {
		return this.accNo;
	}
}
