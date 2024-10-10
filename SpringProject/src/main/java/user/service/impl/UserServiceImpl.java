package user.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.bean.UserPaging;
import user.dao.UserDAO;
import user.service.UserService;

@Service    
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserPaging userPaging;
	
	@Override
	public String getExistId(String id) {
		UserDTO userDTO = userDAO.getExistId(id);
		if(userDTO == null) {
			return "none_exist";
		} else {			
			return "exist";
		}
	}

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
		
	}

	@Override
	public Map<String, Object> list(String pg) {
		// 1. 한페이지당 5개씩
		int endNum = 5;		// 개수
		int startNum = (Integer.parseInt(pg)-1) * endNum;		// 데이터의 시작 위치, MySQL은 0부터 시작
		
		Map<String, Integer> map = new HashedMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		// DB
		List<UserDTO> list = userDAO.list(map);
		
		// 페이징 처리
		int totalA = userDAO.getTotalA(); 		// 총 글수
		userPaging.setCurrentPage(Integer.parseInt(pg));
		userPaging.setPageBlock(3);
		userPaging.setPageSize(5);
		userPaging.setTotalA(totalA);
		userPaging.makePagingHTML();
		
		Map<String, Object> map2 = new HashedMap<String, Object>();
		map2.put("list", list);
		map2.put("userPaging", userPaging);
		
		
		return map2;	// list도 가져가야하고 userPaging도 가져가야한다.
	}

	@Override
	public UserDTO getUser(String id) {
		UserDTO userDTO = userDAO.getExistId(id);		// 쌤 : userDAO.getUser(id)
		return userDTO;
	}

	@Override
	public void update(UserDTO userDTO) {
		userDAO.update(userDTO);
		
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}


}
