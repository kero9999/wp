package com.kero99.wp.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kero99.wp.entity.WpUsers;
import com.kero99.wp.mapper.WpUsersMapper;
import com.kero99.wp.service.WpUsersService;

@Service
public class WpUsersServiceImpl implements WpUsersService{
	@Autowired
	private WpUsersMapper usersMapper;
	public WpUsers queryByAccountPwd(WpUsers users) {
		WpUsers temp = usersMapper.findByAccount(users.getAccount());
		if(temp!=null){
			if(temp.getPassword().equals(DigestUtils.md5Hex(users.getPassword()))){
				return temp;
			}
		}
		return null;
	}
	
}
