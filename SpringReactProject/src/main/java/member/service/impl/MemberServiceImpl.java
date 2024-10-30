package member.service.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import member.dao.MemberDAO;
import member.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memnberDAO;
	@Autowired
	private HttpSession session; //세션
	
	
	@Override
	public String login(String id, String pwd) {
		
		Map<String, String> map = new HashedMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		MemberDTO memberDTO = memnberDAO.login(map);
		if(memberDTO==null) {
			return "fail";			
		} else {
			//HttpSession session = request.getSession() // Autowire안쓰는방법
			
			session.setAttribute("memId", memberDTO.getId());
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@" + memberDTO.getEmail2());
			return "success";
		}
		
		
		
	}
	

}
