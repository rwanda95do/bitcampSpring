package sample01;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageBean")
@Scope("prototype")
public class MessageBeanKo implements MessageBean {

	private int num;		// 필드 (이미 초기화되어있음)
	
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKO 기본 생성자");
	}
	
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println(num);
		System.out.println("안녕하세요 " + name);
		
	}

}
