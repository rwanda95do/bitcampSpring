package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public ModelAndView hello() {	// 스프링 특징 : 사용자가 만든 CallBack Method
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring MVC");	// request.setAtribute부분임.. 
		//mav.setViewName("/hello"); 		// 화면에 보여아하는곳 = jsp파일명 
		mav.setViewName("/view/hello"); ///WEB-INF  /view/hello  .jsp
		return mav;
	}

	
	@RequestMapping(value = "hello2.do", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello2() {
		//return "welcome";
		return "안녕하세요 스프링!!";
	}
	
}

/*
 * URL에서 바로 JSP가 실행되지 않게 하기 위해서 /WEB-INF에 JSP파일을 자성한다 
 * 주소창에서 http://localhost:8080/Chapter06/WEB-INF/hello.jsp로 실행 할 수 없다. 
 * 
 * 스프링에서 리턴타입이 String이면 단순 문자열이 아니라 JSP파일명으로 인식한다
 * @ResponseBody : 단순 문자열로 처리하여 브라우저에 바로 뿌릴때 사용하는 어노테이션. 
 * 반대로 스프링에서는 @ResponseBody가 default다
 *
 * 한글 처리 : produces = "text/html; charset=UTF-8"
 * 
 * 
 * */
 