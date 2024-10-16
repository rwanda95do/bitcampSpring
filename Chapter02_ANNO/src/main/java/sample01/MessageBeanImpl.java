package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost;
	private int qty;


// 생성자
	// @Value("사과") : Spring Value Annotation
	public MessageBeanImpl(@Value("사과") String fruit) {
		this.fruit = fruit;
	}
// Setter
	// @Autowired : Spring Annotation _ 자동으로 불러내
	@Autowired
	public void setCost(@Value("5000") int cost) {
		this.cost = cost;
	}
	@Autowired
	public void setQty(@Value("3") int qty) {
		this.qty = qty;
	}
	/*
	 * 생성자는 new할때 자동으로 생성된다. => @Component 
	 * Setter는 직접 불러내서 사용해야한다. => @Autowired
	 * */



	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}
	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}
	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}

}
