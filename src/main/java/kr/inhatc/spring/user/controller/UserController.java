package kr.inhatc.spring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;

@Controller
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String hello() {	
		return "index";
	}
	
	// GET(read), POST(create), PUT(update), DELETE(delete) 
	@RequestMapping(value = "/user/userList", method=RequestMethod.GET)
	public String userList(Model model) {		
		List<Users> list = userService.userList();
		model.addAttribute("list", list);
		return "user/userList";   
	}
	
	@RequestMapping(value = "/user/userInsert", method=RequestMethod.GET)
	public String userWrite(Model model) {
		List<String> enabledList = new ArrayList<>();
		enabledList.add("가능"); 
		enabledList.add("불가능");   

		List<String> authorityList = new ArrayList<>();
		authorityList.add("ROLE_GUEST");
		authorityList.add("ROLE_MEMBER");
		authorityList.add("ROLE_ADMIN");
 
		Map<String, List<String>> map = new HashMap<>();
		map.put("enabledList", enabledList); 
		map.put("authorityList", authorityList);

		model.addAttribute("map", map);
		
		return "user/userWrite";   
	}
	
	@RequestMapping(value = "/user/userInsert", method=RequestMethod.POST)
	public String userInsert(Users user) {
		userService.saveUsers(user);
		return "redirect:/user/userList"; 
	}
	
	@RequestMapping(value = "/user/userDetail/{id}", method=RequestMethod.GET)
	public String userDetail(@PathVariable("id") String id, Model model) {
		Users user = userService.userDtail(id);
		model.addAttribute("user", user);
		System.out.println("=================> " + user);
		return "user/userDetail";     
	}
	
	@RequestMapping(value = "/user/userUpdate/{id}", method=RequestMethod.POST)
	public String userUpdate(@PathVariable("id") String id, Users user) {	
		System.out.println("==================>" + user);
		
		// 아이디 설정 
		user.setId(id);
		System.out.println("==================>" + user);
		userService.saveUsers(user);
		return "redirect:/user/userList"; 
	}
	
	@RequestMapping(value = "/user/userDelete/{id}", method=RequestMethod.GET)
	public String userDelete(@PathVariable("id") String id) {	
		
		userService.userDelete(id);
		return "redirect:/user/userList"; 
	}
}
