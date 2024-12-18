package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SungJukDelete implements SungJuk {

	@Autowired
	@Qualifier("arrayList")	
	private List<SungJukDTO2> list;

	@Override
	public void excute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();

		// 검색했는지 학인하기 위한 switch변수
		int sw=0;

		// list의 삭제는 idex가 바뀌기 때문에  확장형 For를 쓰면 안된다. -> Iterator(접근지정자) 사용
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()) {		// it가 항목을 가르키는가? 있으면 T, 없으면 F
			SungJukDTO2 sungJukDTO2 = it.next();		// it가 가리키는 항목을 꺼내서 저장, 다음 항목으로 이동
			
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				it.remove(); 		// it.next()로 저장한 항목을 제거한다
				
				System.out.println(name + "님을 삭제하였습니다.");
				break;
			}
			
		}
		
		
		if(sw==0) {
			System.out.println("찾고자하는 이름이 없습니다.");
		}
	}

}
