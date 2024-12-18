package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 아이디 입력 : ");
		String id = scan.next();
		
		UserDTO userDTO = userDAO.getExistId(id);

		if(userDTO == null) {
			System.out.println("삭제하고자하는 아이디가 없습니다.");
			return;  // 함수를 벗어나라
		}
		System.out.println();
		
		userDAO.delete(id);
		
		System.out.println(id + "님의 데이터를 삭제하였습니다.");
	}

}
