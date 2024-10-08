package sample03;

import java.util.Scanner;

public class SungJukImpl implements Sungjuk {
	private String name;
	private int kor, eng, math;
	private int tot;
	private double avg;
	
	public SungJukImpl() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		name = scanner.next();
		System.out.print("국어 입력 : ");
		kor = scanner.nextInt();
		System.out.print("영어 입력 : ");
		eng = scanner.nextInt();
		System.out.print("수학 입력 : ");
		math = scanner.nextInt();

	}
	
	@Override
	public void calc() {
		tot = kor+eng+math;
		avg = (double) tot/3;
	}

	@Override
	public void display() {
		System.out.println("이름 \t국어 \t영어 \t수학 \t총점 \t평균");
		System.out.println(name + " \t" + kor +" \t"+ eng + 
				" \t"+ math +" \t"+ tot +" \t" +String.format("%.2f", avg));
	}

}
