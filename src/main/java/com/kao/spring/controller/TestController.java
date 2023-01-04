package com.kao.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/secured-api")
	public String securedApi() {
		return "secured";
	}

	@GetMapping("/public/open-api")
	public String openApi() {
		return "open";
	}

}
