package sample04;

import java.util.List;

import lombok.Setter;

public class SungJukOutput implements SungJuk {
	@Setter
	private List<SungJukDTO2> list;
	
	
	@Override
	public void excute() {
		System.out.println();
		System.out.println("이름   국어   영어   수학   총점   평균");

		for(SungJukDTO2 sungJukDTO2 : list) {
			System.out.println(sungJukDTO2.toString());
		}
	}

}
