package com.kero99.wp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kero99.wp.common.entity.TreeNode;
import com.kero99.wp.entity.WpUsers;
import com.kero99.wp.service.WpMenuService;

@Controller
@RequestMapping("/menu")
public class WpMenuController {
	@Autowired
	private WpMenuService menuService;
	@RequestMapping("/init")
	@ResponseBody
	public List<TreeNode> init(HttpServletRequest request){
		return menuService.queryByUsers((WpUsers)request.getSession().getAttribute("users"));
	}
}
