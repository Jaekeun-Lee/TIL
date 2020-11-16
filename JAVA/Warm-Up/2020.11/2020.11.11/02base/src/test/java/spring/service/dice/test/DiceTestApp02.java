package spring.service.dice.test;

import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceBImpl;
import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp01.java
 */
public class DiceTestApp02 {
	
	///Main Method
	public static void main(String[] args){
		
		//construct injection
		Player02 player01 = new Player02(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
		
		//setter method injection
		Player02 player02 = new Player02();
		player02.setDice(new DiceBImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player02.getTotalValue());
		System.out.println("=======================");
	}
}//end of class

/*
 * [ 고려할 사항  :: 다른 주사위로 game 을 원할 경우 ]
 * 
 * 		- Player01 은 DiceA를 가지고(?, Has A::Association Relation) 있음.
 * 			(다른 주사위를 사용하려 하면 코딩자체를 수정해야 한다.)
 * 		- Player01 은 DiceA와 밀접한 관련이 있다. ( 결합도가 높다 :: Coupling )
 * 
 *  ==> Player01 / DiceA, DiceB, DiceC 를 리팩도링하면...
 *  1. Player 는 사용할 주사위 객체를 직접 생성않고, 외부로 부터 사용할 주사위를 받는다면... 
 *  	( 주입 :: Injection )
 *  2. Player 는 주사위 사용법을 알고 있으면 된다, 구체적인 DiceA / DiceB / DiceC 는  
 *  	중요한 사항이 아니다.
 *      - Polymorphism  : 하나의 인터페이스로 다양한 활용
 *      - Encapsulation : 인터페이스 뒤로 숨김으로 사용자는 구체적인 사항을 불필요.
  */