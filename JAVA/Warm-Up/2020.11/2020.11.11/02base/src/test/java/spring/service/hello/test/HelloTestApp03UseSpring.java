package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Hello;

/*
 * FileName : HelloTestApp03UseSpring.java
 * ㅇ Hello Bean 사용하는 Application
 * ㅇ Hello Bean 과  dependency Relation
 * ㅇ Spring Framework 에서 제공하는 API를 사용 instance 생성
 * 		[[[ HelloTestApp02와 비교 ]]]
 * 		- hello.properties  ==> hello.xml
 * 		- HelloFactory ==> org.springframework.beans.factory.BeanFactory     
 
	==>	Spring Framework 은 다양한 메타데이터 중  xml 을 일반적으로 사용하며,
	  		instance 생성, 초기화, 객체의 상호 관계를  xml 에 선언적으로 기술. 
	  				
			<bean id="hello" class="spring.services.hello.Hello"/>
			
	==> 	HelloFactory :  Hello Data type 만 관리 하는 Factory 
	==> Spring Framework :모든 Data Type(Bean/POJO) 생성관리하는 Factory
 */
public class HelloTestApp03UseSpring {

	/// main method
	public static void main(String[] args) {

		// 1. BeanFactory 을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/hello.xml"));

		// 2. Container 로 부터 hello 의 name 을 갖는 instance return 받기
		Hello hello = (Hello) factory.getBean("hello");
		hello.printMessage();
	}

}// end of class