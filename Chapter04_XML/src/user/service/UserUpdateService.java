package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Setter
	private UserDAO userDAO;
	@Setter
	private UserDTO userDTO = null;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		userDTO = userDAO.getUser(id);
		
		if(userDTO != null) {
			System.out.println();
			
			System.out.println("이름\t아이디\t비밀번호");
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			
			System.out.println();
			
			System.out.print("수정 할 이름 입력 : ");
			String name = scan.next();
			System.out.print("수정 할 비밀번호 입력 : ");
			String pwd = scan.next();
			
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			
			userDAO.update(userDTO);
			
			System.out.println(id + "님의 데이터를 수정하였습니다.");
		}else {
			System.out.println("찾고자하는 아이디가 없습니다.");
		}
	}

}
