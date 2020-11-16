package spring.service.hello.test;

import spring.service.hello.Hello;
import spring.service.common.HelloFactory;
/*
 * FileName : HelloTestApp02.java
 * ㅇ Hello Bean 사용 Application
 * ㅇ Hello Bean 과  dependency Relation
 * ㅇ [ HelloTestApp01과 비교 ]
 * 		- 사용할  Bean 를 hello.properties(meta-data)에 저장
 * 		- instance 를 직접 생성하지 않으며, HelloFactory 에서 생성,return 되는 instance 사용.
 */
public class HelloTestApp02 {
	
	///main method
	public static void main(String[] args) {
		
		// 1. 사용할 Bean  정보를 갖는  hello.properties(meta-data)를
		//      parsing, Bean instance를 생성할 HelloFactory  instance 생성
		HelloFactory helloFactory =	HelloFactory.getInstance();
		
		// 2.  helloFactory instance 로 parsing 할 resource::meta-data(hello.properties) 전달   
		helloFactory.setConfigResource("./src/main/resources/config/hello.properties");
		
		// 3. helloFactory instance 로 부터 instance.one 이름을 갖는 Hello instance Request  
		Hello hello = helloFactory.getBean("instance.one");
		
		// 4.  printMessage() 호출  
		hello.printMessage();
	}
	
}//end of class


/*
 * [[[[[[ HelloTestApp01 고려할 사항 ]]]]]] 과 비교
 * 
 * [ 고려할 사항 :: 다른 Bean 사용 및 출력 Message 변경 시... ]
 * 
 * 1. new Hello() 의 instance 생성 
 * 		-  Hello.class, 하위 class 또는 다른 class 사용을 할 경우 
 * 			==>  다시 코딩 후 컴파일 과정 수행
 *     [[[[[[ HelloTestApp02 변경 ]]]]]] 
 *     		 : 다른 Bean 사용할 경우 hello.properties 의 내용을 변경한다면....
 * 
 * 2. 출력할 message 하드 코딩 
 *		-  다른 message 를 출력코자 한다면 
 *			==> 다시 코딩 후 컴파일 과정 수행 
 *     [[[[[[ HelloTestApp02 변경 ]]]]]]
 *     		 : HelloTestApp02는 미적용
 *			 ==> hello.properties 에 Message 를 저장 불러올 수 있다면....
 */