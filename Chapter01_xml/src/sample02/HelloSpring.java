package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		
		Calc calc = (Calc) context.getBean("calcAdd");
		calc.calculate(25, 36);
		
		// 클래스를 알려주면 캐스팅을 안걸오도됨
		calc = context.getBean("calcMul", Calc.class);
		calc.calculate(25, 36);
	}

}
