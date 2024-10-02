package sample05;
// Spring Life Cycle을 확인하기 위한 "내용 파일 출력 예제"
	// applicationContext.xml에 적은 순서대로 생성한다

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = (MessageBean) context.getBean("messageBeanImpl05");
		messageBean.helloCall();

	}

}
