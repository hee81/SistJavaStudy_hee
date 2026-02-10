package com.boot.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/bts/butter")
	public HashMap<String, String> hello(){
		HashMap<String, String> map = new HashMap<>();
		
		map.put("msg", "오늘도 좋은 하루");
		
		return map;
	}
}
