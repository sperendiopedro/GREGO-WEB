package grego.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MenuController {

	@GetMapping("/home")
	public String acessMenu() {
		return "HomeMenu/home";
	}

	@GetMapping("/user/menu")
	public String userMenuForm() {
		return "/UserMenu/menu";
	}
	
	@GetMapping("/empresa/menu")
	public String empMenu() {
		return "EmpMenu/menu"; 
	}
	
	@GetMapping("/auth/register")
	public String register() {
		return "/UserMenu/cadastro"; 
	}
}

