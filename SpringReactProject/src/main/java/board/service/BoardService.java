package board.service;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {

	public void boardWrite(String subject, String content);

	public List<BoardDTO> boardList();

	public BoardDTO boardView(int seq);



}
