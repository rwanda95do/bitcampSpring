package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcMul;
import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample04.SungJukDTO2; 

// 스프링 설정 파일과 같은 역할을 할 JAVA 파일 = applicationContext.xml가 괕은 역할을 할 파일 
@Configuration
public class SpringConfiguration {
/*
	// @Component 클래스 위에, @Bean은 메서드 위에
	@Bean
	public MessageBeanImpl messageBeanImpl(){
		return new MessageBeanImpl("사과");
	} 
*/	
	// 더 자바처럼 사용하려면 
	@Bean(name = "messageBeanImpl")
	public MessageBeanImpl getMessageBeanImpl(){
		return new MessageBeanImpl("사과");
	} 
	
// sample02 
	@Bean
	public CalcMul calcMul(){
		return new CalcMul();
	}
	
// sample 03
	@Bean
	public SungJukDTO sungJukDTO() {
		return new SungJukDTO();
	}
	@Bean
	public SungJukImpl sungJukImpl() {
		return new SungJukImpl();
	}
	
// sample 04
	@Bean
	public ArrayList<SungJukDTO2> arrayList(){
		return new ArrayList<SungJukDTO2>();
	}
}
/*
 * @Bean
 * 메서드에서  return 되는 값을 스프링의 bean으로 생성한다.
 * 메서드명은 반드시 bean에 id명으로 해야한다. 
 * 메서등명을 자바처럼 getter로 사용하려면 @Bean(name="")를 사용해야한다.
 * 
 * 
 * @Component
 * 클래스를 스프링의 bean으로 생성한다.
 * */
 