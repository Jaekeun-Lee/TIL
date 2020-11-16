package spring.service.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class LifeCycle01 implements BeanNameAware {

	public LifeCycle01() {
		System.out.println(getClass().getName()+"의 디폴트 생성자");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(getClass().getName()+"의 오버라이딩된 setBean start");
		System.out.println("setBeanName = "+name);
		System.out.println(getClass().getName()+"의 오버라이딩된 setBean end");
	}
	
	public void init() {
		System.out.println(getClass().getName()+"init()");
	}
	
	public void destory() {
		System.out.println(getClass().getName()+"destory()");
	}

}
