package sample03;

import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SungJukImpl implements SungJuk {
	private SungJukDTO sungJukDTO = null;

/*	
// 생성자	
	public SungJukImpl(SungJukDTO sungJukDTO) {
		super();
		this.sungJukDTO = sungJukDTO;
	}
*/
	
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
