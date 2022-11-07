package com.greatlearning.studentregistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	/*
	 * this page gets loaded when our application is booted
	 * url: "/studentcollegefest/"
	 * returns viewname "main-page"
	 */
	@RequestMapping("/")
	public String showMainPage() {

		return "main-page";
	}
}
