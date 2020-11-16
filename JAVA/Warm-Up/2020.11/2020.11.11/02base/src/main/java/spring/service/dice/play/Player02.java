package spring.service.dice.play;

import spring.service.dice.Dice;

/*
 *	FileName : Player01.java
 *	ㅇ DiceA 을 가지고(?, has a :: Association Relationship)있는 Player Object 
 *  ㅇ DiceA 를 사용, 합을 리턴하는 Method Definition 
 */
public class Player02 {
	
	///Field
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
		System.out.println("Player02 - 디폴트 생성자....");
		this.dice = dice;
	}
	public Player02(Dice dice) {
		System.out.println("Player02 - Dice 인스턴스를 인자로 받는 생성자....");
		this.dice = dice;
	}
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class