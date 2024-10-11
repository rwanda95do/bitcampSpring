package user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value = "getExistId", method = RequestMethod.POST)
	@ResponseBody
	public String getExistId(String id) {
		return userService.getExistId(id); 		// ajax를 이용했기 때문에 js파일로 돌아가야한다. jsp파일명이 아니라 단순 문자열로 만들어 준다>> @ResponseBody
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET )
	public String list(@RequestParam(required = false, defaultValue = "1") String pg, Model model) {
		// 데이터를 담을 수 있는 방법 : 1. ModelAndView 2.ModelMap 3.Model
		Map<String, Object> map2 = userService.list(pg);
		
		map2.put("pg", pg);
		model.addAttribute("map2", map2);		// 클라이언트에서 꺼내서 써야함
		
		/*// 또는 각자꺼내서 보낸다
		model.addAttribute("list", map2.get("list"));
		model.addAttribute("userPaging", map2.get("userPaging"));
		*/
		return "/user/list";     //  /WEB-INF   /user/list   .jsp
	}
	
	@RequestMapping(value = "updateForm", method = RequestMethod.GET)
	public String updateForm(@RequestParam String id, @RequestParam String pg, ModelMap modelMap) {
		UserDTO userDTO = userService.getUser(id);
		
		modelMap.put("userDTO", userDTO);
		modelMap.put("pg", pg);
		
		return "/user/updateForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody  // Error : 없으면 ajax로 돌아가지 못한다. 다시 돌아가야하니까 꼭 써주기
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
	
	
	@RequestMapping(value = "deleteForm", method = RequestMethod.GET)
	public ModelAndView deleteForm(@RequestParam String id, @RequestParam String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);		// session이 있으면 session을 얻어오면 되기 때문에 필요가 없어진다.
		mav.addObject("pg", pg);
		mav.setViewName("/user/deleteForm");
		
		return mav;
	}
	
	@RequestMapping(value = "getExistPwd", method = RequestMethod.POST)
	@ResponseBody
	public UserDTO getExistPwd(@RequestParam String id, Model model) {
		// 받는 쪽이 json이기 때문에 json으로 만들어 줘야한다.:JSONObject
		// 스프링은 객체를 자동으로 json으로 변경해 준다. >> pom.xml에json사용한다고 알려줘야함
		return userService.getExistPwd(id);
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
}
