package com.tawfik.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.tawfik.userfront.domain.User;
import com.tawfik.userfront.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@PostMapping("/signup")
	public String singupPost(@ModelAttribute("user") User user,Model model) {
		if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
			
			if(userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}
			
			if(userService.checkUsernameExist(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			
			return "signup";
			
		}else {
			System.out.println("saved ..... ");
			userService.saveUser(user);
			return "redirect:/";
		}
				
	}
	
}
