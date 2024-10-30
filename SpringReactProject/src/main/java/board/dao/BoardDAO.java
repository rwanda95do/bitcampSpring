package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.bean.BoardDTO;

@Mapper
public interface BoardDAO {

	public void boardWrite(Map<String, String> map);

	public void refUpdate();

	public List<BoardDTO> boardList();

	public BoardDTO boardView(int seq);

}