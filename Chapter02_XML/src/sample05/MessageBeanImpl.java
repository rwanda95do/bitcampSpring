package sample05;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class MessageBeanImpl implements MessageBean {

	private String name;	
	private String phone;
	private Outputter outputter;

	

	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("생성자 : MessageBeanImpl(String name)");
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("SETTER : setPhone(String phone))");
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("SETTER : setOutputter(Outputter outputter)");
	}




	@Override
	public void helloCall() {
		System.out.println("helloCall()");
		outputter.output("나의 이름은 " + name + "이고, 핸드폰은 " + phone +"이다.");
	}
	
}
