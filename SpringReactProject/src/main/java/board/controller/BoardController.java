package board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;
import board.service.BoardService;


//@Controller : jsp를 찾아가지 않기 때문에 controller가 필요없다. 대신 @RestController
@RestController  // @RestController를 사용하면 @@ResponseBody를 사용할 필요가 없다
@RequestMapping(value = "board")
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	//@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	@PostMapping(value = "boardWrite")
	public void boardWrite(@RequestParam String subject, @RequestParam String content) {
		//System.out.println(subject);
		boardService.boardWrite(subject, content);
	}
	
	@GetMapping(value = "boardList")
	public List<BoardDTO> boardList(){ 
		
		return boardService.boardList();
	}
	
	@RequestMapping(value = "boardView")
	public BoardDTO boardView(@RequestParam int seq) {
		return boardService.boardView(seq);
		
	}

}
