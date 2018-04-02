package com.kero99.wp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kero99.wp.common.entity.TreeNode;
import com.kero99.wp.entity.WpUsers;
import com.kero99.wp.mapper.WpMenuMapper;
import com.kero99.wp.service.WpMenuService;
@Service
public class WpMenuServiceImpl implements WpMenuService {
	@Autowired
	private WpMenuMapper menuMapper;
	public List<TreeNode> queryByUsers(WpUsers users) {
		List<TreeNode> tops = menuMapper.findByUsers(users);
		for (TreeNode top : tops) {
			top.setChildren(menuMapper.findByUsersParent(users, top.getId()));
		}
		return tops;
	}

}
