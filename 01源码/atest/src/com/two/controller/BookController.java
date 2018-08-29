package com.two.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/api/atest/book")
public class BookController {

	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<String> getSelectOu(String userid) throws Exception{
		return ResponseEntity.ok("success");
	} 
	
}
