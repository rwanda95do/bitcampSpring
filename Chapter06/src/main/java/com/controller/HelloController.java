package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public ModelAndView hello() {	// 사용자가 만든 CallBack Method
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring MVC");	// request.setAtribute부분임.. 
		mav.setViewName("hello"); 		// 화면에 보여아하는곳 = jsp파일명 
		return mav;
	}
	
}
