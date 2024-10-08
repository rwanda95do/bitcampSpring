package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CalcAdd calcAdd = context.getBean("calcAdd", CalcAdd.class);
		calcAdd.calculate();
		
		CalcMul calcMul = context.getBean("calcMul", CalcMul.class);
		calcMul.calculate();

	}

}
