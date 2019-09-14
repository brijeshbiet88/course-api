package io.javabrains.springbootstarter.course;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/")
	public class HomeController {
	    
	    public String index2() {
	        return "index2.html";
	    }
	}
