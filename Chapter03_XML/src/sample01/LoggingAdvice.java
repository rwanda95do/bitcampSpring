package sample01;
// 공통 관심 사항(코드) 

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace");
	}
	
	public void afterTrace() {
		System.out.println("before trace");
	}
	
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
	/*	
		System.out.println("입실");
		// 핵심코드를 수행하는 메소드 호출
		joinPoint.proceed();
		System.out.println("퇴실");
	*/
		
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("메소드 : " + methodName );
		
		// 프로그램 수행 시간 계산 : StopWatch
		StopWatch stopWatch =  new StopWatch();
		stopWatch.start();
		
		Object ob = joinPoint.proceed();
		System.out.println("반환값 :" + ob);
		
		stopWatch.stop();
		System.out.println("처리시간 : " + stopWatch.getTotalTimeMillis()/1000 + " 초");
	}
}
