package spring.service.hello.test;

import spring.service.hello.Hello;

/*
 * FileName : HelloTestApp01.java
 * ㅇ Hello Bean 사용하는 Application
 * ㅇ Hello Bean 과  dependency Relation
 */
public class HelloTestApp01 {
	
	///main method
	public static void main(String[] args) {
		//==>1. instance 생성 
		Hello hello = new Hello();
		//==> 2. printMessage() method 호출
		hello.printMessage();
	}
	
}//end of class

/*
 * [ 고려할 사항 :: 다른 Bean 사용 및 출력 Message 변경 시... ]
 * 
 * 1. new Hello() 의 instance 생성 코딩
 * 		-  Hello.class, 하위 class 또는 다른 class 사용을 할 경우 
 * 			==>  다시 코딩 후 컴파일 과정 필요
 * 
 * 2. 출력할 message 하드 코딩 
 *		-  다른 message 를 출력코자 한다면 
 *			==> 다시 코딩 후 컴파일 과정 수행 
 *
 *  ==> 위의 하드코딩된 부분(1.instance 생성, 2.출력 message)을 
 *  		text file(부가정보,Meta Data) 에 저장  Application 은 runtime 시  text 에 저장된 내용을 
 *  		읽어 수행하는 구조라면, 사용 할 instance/message 에  변경사항이 발생하면 text 만 수정
 *  		Application 은  text 를 통해 전달된 정보를 사용 함으로 수정 할 필요가 없다
  */