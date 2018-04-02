package com.kero99.wp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kero99.wp.entity.WpUsers;
import com.kero99.wp.service.WpUsersService;

@Controller
@RequestMapping("/users")
public class WpUsersController {
	@Autowired
	private WpUsersService usersService;
	@RequestMapping("/login")
	@ResponseBody
	public WpUsers login(WpUsers users,HttpServletRequest request){
		users=usersService.queryByAccountPwd(users);
		if(users!=null){
			request.getSession().setAttribute("users", users);
		}
		return users;
	}
	@RequestMapping("/isLogin")
	@ResponseBody
	public WpUsers isLogin(HttpServletRequest request){
		return (WpUsers) request.getSession().getAttribute("users");
	}
	@RequestMapping("/exit")
	@ResponseBody
	public void exit(HttpServletRequest request){
		request.getSession().invalidate();
	}
}
