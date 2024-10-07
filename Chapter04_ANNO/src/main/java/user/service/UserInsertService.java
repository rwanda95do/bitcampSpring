package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

//@Component
@Service			// @Service : 서비스 로직을 나타내는 annotation
public class UserInsertService implements UserService {
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;


	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("아이디 : ");
		String id = scanner.next();
		System.out.println("비밀번호 : ");
		String pwd = scanner.next();
		
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		
	// DB
		//UserDAO userDAO = new UserDAO() < bean, 싱글톤 
		userDAO.write(userDTO);
		System.out.println(name + "님의 데이터를 저장하였습니다.");
		
	}

}
