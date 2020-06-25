package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@GetMapping("/accounts/{number}")
	public String getAccountDetails() {
		return "{ number: \"00987987973432\", type: \"savings\", balance: 234343 }";
	}
}
