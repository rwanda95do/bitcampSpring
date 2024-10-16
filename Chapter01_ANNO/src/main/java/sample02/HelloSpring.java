package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;


public class HelloSpring {

	public static void main(String[] args) {
		
		//Calc calc = new CalcAdd();

		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
		
		Calc calc = (Calc) context.getBean("calcAdd");
		calc.calculate(25, 36);
		
		calc = (Calc) context.getBean("calcMul", Calc.class);
		calc.calculate(25, 36);
		
	}

}
