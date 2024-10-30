package board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import board.service.BoardService;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private HttpSession session;
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void boardWrite(String subject, String content) {
		//세션
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String email = (String) session.getAttribute("memEmail");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("subject", subject);
		map.put("content", content);
		
		map.put("id", id);	// 세션
		map.put("name", name);  // 세션
		map.put("email", email); // 세션
		
		boardDAO.boardWrite(map);
		boardDAO.refUpdate();
		
	}

	@Override
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = boardDAO.boardList();
		System.out.println(list); // List<BoardDTO>객체를 자동으로 JSON배열로 변환하여 보낸다 -> pom.xml의 json dependencs
		return list;
	}

	@Override
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = boardDAO.boardView(seq);
		System.out.println(boardDTO);
		return boardDTO;
	}


}
