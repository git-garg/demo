package ec.com.empresa.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:/app/index";
		//return "redirect:https://www.google.com";
		//return "forward:/app/index";
	}

}
