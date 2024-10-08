package sample01;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {

		/*
		 * MessageBeanKo messageBeanKo = new MessageBeanKo(); // 1:1, 결합도 100%
		 * messageBeanKo.sayHello("hong"); MessageBean messageBean = new
		 * MessageBeanKo(); // 부모=자식 (다형성), 결합도 낮추기 messageBean.sayHello("Spring");
		 */
	// 위에처럼 하지말고	
	// 스프링한테 맡겨라!!! 변환되는 클래스 생성을 스프링이 해줄겠다!!
	// 스프링 설정파일 : applicationContext.xml
		// 1. applicationContext.xml에 bean을 생성하세요~
		// 2. applicationContext.xml을 알리시오
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean1 = (MessageBean) context.getBean("messageBean");		//  applicationContext.xml의 bean의 id값
		messageBean1.sayHello("kim");
		
	// 놀라워라! 싱글톤이었네?!
		MessageBean messageBean2 = (MessageBean) context.getBean("messageBean");		
		messageBean2.sayHello("Gim");
		
		MessageBean messageBean3 = (MessageBean) context.getBean("messageBean");		
		messageBean3.sayHello("Rim");
		
	}

}
