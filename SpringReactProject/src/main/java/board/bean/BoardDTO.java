package board.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardDTO {
	private int seq;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	private int ref;
	private int lev;
	private int step;
	private int pseq;
	private int reply;
	private int hit;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul") //시간을 한국 시간으로 안가져옴
	private Date logtime;
}
