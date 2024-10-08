package com.controller;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;


@Controller
@Component
public class SumController {

	@RequestMapping(value = "input.do", method = RequestMethod.GET)
	public String input(){
		return "/sum/input";	// /WEB-INF  /sum/input   .jsp
	}
	
	// 방법1. jsp가 직접 데이터를 받는다. param을 사용
//	@RequestMapping(value = "result.do", method = RequestMethod.GET)
//	public String result() {
//		return "/sum/result";  // /WEB-INF /sum/result   .jsp
//	}
	/*
	// 방법2.
	@RequestMapping(value = "result.do", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("/sum/result");
		return mav;  // /WEB-INF /sum/result   .jsp
	}
	*/
	 
	/*
	// 방법3. 아무입력도 들어오지 않았을 때 기본값으로 0을 준다. @RequestParam(required = false, defaultValue = "0")
		// String인데도 웹에서는 숫자로 취급하고 계산을 해준다
	@RequestMapping(value = "result.do", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x,
							   @RequestParam(required = false, defaultValue = "0") String y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("/sum/result");
		return mav;  // /WEB-INF /sum/result   .jsp
	}
	*/
	
	/*
	// 방법4. 데이터양에 따라서 Map을 사용할 수도 있다.
	// 데이터를 보낼 때 ModelAndView 대신  ModelMap 을 사용할 수도 있다.
	@RequestMapping(value = "result.do", method = RequestMethod.GET)
	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
		modelMap.put("x", map.get("x"));
		modelMap.put("y", map.get("y"));
		return "/sum/result";  // /WEB-INF /sum/result   .jsp
	}
	 */
	
	
	// 방법5. 데이터의 양이 많아 DTO를 사용하는 경우
	@RequestMapping(value = "result.do", method = RequestMethod.GET)
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
		return "/sum/result";  // /WEB-INF /sum/result   .jsp
	}
	
	
	
}
