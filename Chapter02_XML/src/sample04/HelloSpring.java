package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	// 리스트를 xml에 싱글톤으로 만들지 않는다면
	// List<SungJukDTO2> list = new ArrayList<SungJukDTO2>();
	// excute(list)의 형식으로 넘겨주어야 한다. 그러면 연쇄반응으로 interface, class파일들을 같이 수정해줘야한다.

	public static void main(String[] args) {
		// main을 가지고 있는 HelloSpring은 한번만 호출되기 때문에 아래처럼 만들어도된다. 
		// HelloSpring helloSpring = new HelloSpring();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");
		
	}

	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;
		int num;
		while(true) {
			System.out.println("******************");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.끝");
			System.out.println("******************");
			System.out.print("번호 : ");
			num = scan.nextInt();
			
			if(num == 5) {
				break;
			} else if(num == 1) {
				//SungJuk sungJuk = new SungJukInput();
				InsertService  insertService = new insertService()
				insertService.execute();
			} else if (num == 2) {
				UpdateService  updateService = new UpdateService()
				insertService.execute();
			} else if (num == 3) {
				sungJuk = context.getBean("sungJukUpdate", SungJuk.class);
			} else if (num == 4) {
				sungJuk = context.getBean("sungJukDelete", SungJuk.class);
			}
			
		}
	}

}
