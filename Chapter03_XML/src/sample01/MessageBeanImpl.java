package sample01;

import lombok.Setter;

public class MessageBeanImpl implements MessageBean {
	@Setter
	private String str;

	@Override
	public void dispaly() {
		System.out.println("dispaly 메시지 : " + str);
	}
// ============================================
	
	@Override
	public void showPrintBefore() {
		// System.out.println("before trace");
		System.out.println("showPrintBefore 메시지 : " + str);  // 핵심코드
	}

	@Override
	public void viewPrintBefore() {
		// System.out.println("before trace");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrintBefore 메시지 : " + str);
	}

// ===========================================
	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 : " + str);  // 핵심코드
		// System.out.println("before trace");		
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrintAfter 메시지 : " + str);
		// System.out.println("before trace");
		
	}
	
// ==============================================

	@Override
	public String showPrint() {
		// System.out.println("before trace");
		System.out.println("showPrint 메시지 : " + str);  // 핵심코드
		// System.out.println("before trace");
		return "스프링";
	}

	@Override
	public void viewPrint() {
		// System.out.println("before trace");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrint 메시지 : " + str);
		// System.out.println("before trace");
		
	}
}
