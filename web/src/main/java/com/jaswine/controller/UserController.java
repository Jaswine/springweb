package com.jaswine.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户Controller
 * @author Jaswine
 */
@RestController
@RequestMapping("/user")
@Slf4j
@ControllerAdvice
public class UserController {


	@GetMapping("/{name}")
	public void getName(@PathVariable String name){
		log.info("接收到的name参数值为:{"+name+"}");
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String noHandlerFound(HttpServletRequest request, HttpServletResponse response){
		return "NO FOUND";
	}

}
