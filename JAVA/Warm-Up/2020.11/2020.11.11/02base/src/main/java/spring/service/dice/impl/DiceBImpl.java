package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

/*
 * FileName : DiceB.java
 * ㅇ 주사위 Object Modeling
 * ㅇ 1 ~ 6 수를 랜덤하게  리턴
 */
public class DiceBImpl implements Dice {
	
	///Field
	private int value;

	///Constructor
	public DiceBImpl() {
		System.out.println("::"+getClass().getName()+" 생성자....");
	}

	//Method (getter/setter)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//==> 주사위를 던저 무작위로 숫자 생산
	public void selectedNumber(){
		value = new Random().nextInt(6) + 1;
	}
	
}//end of class