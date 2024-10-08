package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

@Controller  // @Component가 없어도 @Controller만으로도 bean생성이 된다.
public class SungJukController {
	
	@RequestMapping(value = "/sungJuk/input.do", method = RequestMethod.GET)
	public String input() {
		return "/sungJuk/input";  //  /WEB-INF  /sungJuk/input   .jsp
	}
	
	
	
	//produces = "text/html; charset=UTF-8" : 요청으로 오는 한글 깨짐 방지
	@RequestMapping(value = "/sungJuk/result.do", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap map) {
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng()+sungJukDTO.getMath());
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
		map.put("sungJukDTO", sungJukDTO);
		return "/sungJuk/result";  //  /WEB-INF  /sungJuk/input   .jsp
	}

}
