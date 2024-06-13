package com.ieumsae.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {
	@GetMapping("path")
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	@GetMapping("path")
	public String memberController(@RequestParam String param) {
	    return new String();
	}

}
