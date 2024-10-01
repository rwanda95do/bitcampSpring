package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SungJukImpl implements SungJuk {
// SungJukDTO의 기본 생성자가 만들어 졌기 때문에 기본값만 처리되고 있는 중.. 
// Setter값이되려면? 
// 생성된 빈들 중에서, @Component("sungJukDTO")를 찾아서 자동으로 매핑해라!!
	// 생성자이건 setter이건 상관없이 sungJukDTO를 찾아서 자동으로 매핑해라
	@Autowired
	private SungJukDTO sungJukDTO = null;

	
// 메소드 오버라이드	
	@Override
	public void calcTot() {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		sungJukDTO.setTot(tot);
	}

	@Override
	public void calcAvg() {
		double avg = (double)sungJukDTO.getTot() / 3;
		sungJukDTO.setAvg(avg);
	}

	@Override
	public void display() {
		System.out.println("이름  국어  영어  수학  총점  평균");
		System.out.println(sungJukDTO);
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름입력 : ");
		String name = scan.next();
		System.out.println("국어 점수 입력 : ");
		int kor = scan.nextInt();
		System.out.println("영어 점수 입력 : ");
		int eng = scan.nextInt();
		System.out.println("수학 점수 입력 : ");
		int math = scan.nextInt();
		
		sungJukDTO.setName(name);;
		sungJukDTO.setKor(kor);
		sungJukDTO.setEng(eng);
		sungJukDTO.setMath(math);
	}

}
