package com.kero99.wp.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kero99.wp.entity.WpUsers;


@Repository
public interface WpUsersMapper {
	@Select("select * from wp_users where account = #{account}")
	WpUsers findByAccount(String account);

}
