package com.kero99.wp.service;

import java.util.List;

import com.kero99.wp.common.entity.TreeNode;
import com.kero99.wp.entity.WpUsers;

public interface WpMenuService {

	List<TreeNode> queryByUsers(WpUsers attribute);

}
