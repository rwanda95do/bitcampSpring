package sample04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukOutput implements SungJuk {
	@Autowired
	@Qualifier("arrayList")	
	private List<SungJukDTO2> list;
	/* List는 부모, ArrayList는 자식
	 * @Qualifier가 없다면, List가 자식들 중 누구를 가르키는지 모른다.
	*/

	@Override
	public void excute() {
		System.out.println();
		System.out.println("이름   국어   영어   수학   총점   평균");

		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2.toString());
		}
	}

}
