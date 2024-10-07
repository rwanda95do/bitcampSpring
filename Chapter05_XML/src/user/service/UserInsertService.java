package user.service;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserInsertService implements UserService {
	private UserDTO userDTO;
/* setter Injection
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
*/
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
