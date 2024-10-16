package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukUpdate implements SungJuk {

	@Setter
	private List<SungJukDTO2> list;

	@Override
	public void excute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		int sw=0;
		
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				
				System.out.println("이름   국어   영어   수학   총점   평균");
				System.out.println(sungJukDTO2.toString());
				
				System.out.println();
				
				System.out.print("국어점수 입력 : ");
				int kor = scan.nextInt();
				System.out.print("영어점수 입력 : ");
				int eng = scan.nextInt();
				System.out.print("수학점수 입력 : ");
				int math = scan.nextInt();
				
				int tot = kor + eng + math;
				double avg = tot/3.0;
				
				sungJukDTO2.setName(name);
				sungJukDTO2.setKor(kor);
				sungJukDTO2.setEng(eng);
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot(tot);
				sungJukDTO2.setAvg(avg);
				
				System.out.println(name + "님의 데이터를 입력하였습니다.");
				
				break;		// 이름에 중복이 없으니 찾고서 for문을 빠져나간다
			}
		} // for
		
		if(sw==0) {
			System.out.println("찾고자하는 이름이 없습니다.");
		}
	}

}
