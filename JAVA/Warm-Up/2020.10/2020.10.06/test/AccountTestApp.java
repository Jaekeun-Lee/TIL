package test;

import Account;

public class AccountTestApp {

	public static void main(String[] args) {

		// 계좌 1번 ( 마이너스 통장 O )
		Account account01 = new Account("111-111-111", true, 1000000, 100000);

		try {

			System.out.println("=====Account01=====");
			System.out.println("0, 최초 계좌 상태");
			System.out.println("[계좌 정보] " + account01);

			System.out.println("\n1. " + account01.getAccountNo() + " 계좌 200000원 출금 요청");
			account01.withdraw(200000);
			System.out.println("[계좌 정보] " + account01);

			System.out.println("\n2. " + account01.getAccountNo() + " 계좌 100000원 입금 요청");
			account01.deposit(100000);
			System.out.println("[계좌 정보] " + account01);

			System.out.println("\n3. " + account01.getAccountNo() + " 계좌 500000원 출금 요청");
			account01.withdraw(500000);
			System.out.println("[계좌 정보] " + account01);

			System.out.println("\n4. " + account01.getAccountNo() + " 계좌 600000원 출금 요청");
			account01.withdraw(600000);
			System.out.println("[계좌 정보] " + account01);

		} catch (Exception e) {
			System.out.println("예외 발생 >>> : " + account01.getAccountNo() + " : " + e.getMessage());
		}

		System.out.println("\n=====Account02=====");
		// 계좌 2번 ( 마이너스 통장 X )
		Account account02 = new Account();

		try {

			account02.setAccountNo("222-222-222");
			System.out.println("0, 최초 계좌 상태");
			System.out.println("[계좌 정보] " + account02);

			System.out.println("\n1. " + account02.getAccountNo() + " 계좌 100000원 입금 요청");
			account02.deposit(100000);
			System.out.println("[계좌 정보] " + account02);

			System.out.println("\n2. " + account02.getAccountNo() + " 계좌 50000원 출금 요청");
			account02.withdraw(50000);
			System.out.println("[계좌 정보] " + account02);

			System.out.println("\n3. " + account02.getAccountNo() + " 계좌 60000원 출금 요청");
			account02.withdraw(60000);
			System.out.println("[계좌 정보] " + account02);

		} catch (Exception e) {
			System.out.println("예외 발생 >>> : " + account02.getAccountNo() + " : " + e.getMessage());
		}

		
		System.out.println("\n=====Account03=====");
		Account account03 = new Account();
		System.out.println("[계좌 정보] " + account03);
	}

}
