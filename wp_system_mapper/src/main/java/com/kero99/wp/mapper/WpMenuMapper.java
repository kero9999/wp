package com.kero99.wp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kero99.wp.common.entity.TreeNode;
import com.kero99.wp.entity.WpUsers;
@Repository
public interface WpMenuMapper {
	@Select("select * from wp_menu where id in (select pid from wp_menu where id in (select menuid from wp_users_menu where usersid=#{id}) group by pid)")
	@Results({
		@Result(column="id",property="id"),
		@Result(column="name",property="text")
	})
	List<TreeNode> findByUsers(WpUsers users);
	@Select("select * from wp_menu where id in(select menuid from wp_users_menu where usersid=#{users.id}) and pid=#{pid}")
	@Results({
		@Result(column="id",property="id"),
		@Result(column="name",property="text"),
		@Result(column="url",property="url")
	})
	public List<TreeNode> findByUsersParent(@Param("users")WpUsers users,@Param("pid")Long pid);

}	
