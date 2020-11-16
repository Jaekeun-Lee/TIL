package spring.service.hello;

/*
 * FileName : Hello.java
 * ㅇ Bean 규약 : 
 *      - package / private Field(property) /  getter,setter 
 *      - Default Constructor / 필요한 Method definition 
 * ㅇ POJO(Plain Old Java Object)
 *     - 특정 규약에 종속적이지 않는다 //==> 꼭 필요한 기본 API외 종속적이지 않는다.
 *     - 특정 환경에 종속적이지 않는다 //==> 특정환경에서만 운용되지 않는다.
 */
public class Hello{
	
	///Field
	private String message = "Container 란 무었인가.";
	
	///Constructor Method
	public Hello() {
	}
	public Hello(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message 를 출력하는 Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class