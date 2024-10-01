package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//context.getBean("스프링 설정파일(applicatoinContext.xml) 에서 만든 bean의 id 값");
		MessageBean messageBean = context.getBean("messageBeanImpl", MessageBean.class);
		messageBean.sayHello();
		messageBean.sayHello("딸기", 10000);
		messageBean.sayHello("참외", 3500, 10);
		
	}

}
