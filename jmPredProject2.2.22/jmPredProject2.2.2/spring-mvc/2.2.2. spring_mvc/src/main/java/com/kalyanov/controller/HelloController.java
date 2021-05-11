package com.kalyanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kalyanov.service.Service;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	private Service service;

	@Autowired
	public void setService (Service service) {
		this.service = service;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "/Car")
	public String loopListExample(@RequestParam(value = "countCa", required = false) String counCa, Model model) {
        if (counCa == null || Integer.valueOf(counCa) >= 5) {
			model.addAttribute("people", service.getListCar());
			return "indexcar";
		} else {
			model.addAttribute("people", service.getCarCount(Integer.valueOf(counCa)));
			return "indexcar";
		}
	}
}