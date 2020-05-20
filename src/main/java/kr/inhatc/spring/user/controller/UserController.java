package kr.inhatc.spring.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.inhatc.spring.board.dto.BoardDto;
import kr.inhatc.spring.board.service.BoardService;
import kr.inhatc.spring.user.entity.Users;
import kr.inhatc.spring.user.service.UserService;

@Controller
public class UserController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String hello() {		
		return "redirect:/user/userList";
	}
	
	// GET(read), POST(create), PUT(update), DELETE(delete) 
	@RequestMapping(value = "/user/userList", method=RequestMethod.GET)
	public String userList(Model model) {		
		List<Users> list = userService.userList();
		model.addAttribute("list", list);
		return "user/userList";   
	}
}
