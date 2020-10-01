package bill;

public class PhoneBill {

	public static void main(String[] args) {
		CellPhone cellPhone = new CellPhone("010-010-010",1000);
		
		cellPhone.call("017-017-017", 10);
		cellPhone.call("016-016-016", 10);
		cellPhone.calculationTotalFee();
		System.out.println(cellPhone.getPhoneNumber()+"의 총 통화 시간은"
				+ cellPhone.getTotalCallTime()+"분 이며\n"+
				"분당 요금은 "+cellPhone.getFeePerCallTime()+
				"원이고 총 요금은 "+cellPhone.getTotalFee()+"원 입니다.");
		
		System.out.println("===============================");
		
		SmartPhone smartPhone = new SmartPhone("000-000-000",200);
		smartPhone.call("017-017-017", 10);
		smartPhone.calculationTotalFee();
		System.out.println(smartPhone.getPhoneNumber()+"의 통화 시간은"
				+ smartPhone.getTotalCallTime()+"분 이며\n"+
				"분당 요금은 "+smartPhone.getFeePerCallTime()+
				"원이고 총 요금은 "+smartPhone.getTotalFee()+"원 입니다.");
		
		System.out.println("===============================");
		
		SmartPhone smartPhone2 = new SmartPhone("111-111-111",0,true,3000);
		smartPhone2.call("017-017-017", 10);
		smartPhone2.call("016-016-016", 10);
		smartPhone2.calculationTotalFee();
		System.out.println(smartPhone2.getPhoneNumber()+"의 통화 시간은"
				+ smartPhone2.getTotalCallTime()+"분 이며\n"+
				"분당 요금은 "+smartPhone2.getFeePerCallTime()+
				"원이고 총 요금은 "+smartPhone2.getTotalFee()+"원 입니다.");
	}

}
