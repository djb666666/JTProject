package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.service.UserService;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/check/{param}/{type}")
	public JSONPObject checkUser(@PathVariable String param,
					      		@PathVariable Integer type,
					      		String callback) {
		JSONPObject jsonpObject;
		try {
			boolean flag=userService.findUserById(param,type);
			jsonpObject=new JSONPObject(callback,SysResult.success(flag));
		} catch (Exception e) {
			e.printStackTrace();
			jsonpObject=new JSONPObject(callback, SysResult.fail());
		}
	
		return jsonpObject;
	}
	
	
	
	
}
