/**
 * 
 */
package com.guozihui.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guozihui.cms.dao.UserMapper;
import com.guozihui.cms.domain.User;
import com.guozihui.cms.service.UserService;

/**
 * 说明:用户服务
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:10:12
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	protected UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.UserService#get(int)
	 */
	@Override
	public User get(int id){
		return userMapper.selectById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bawei.cms.service.impl.UserService#get(java.lang.String)
	 */
	@Override
	public User get(String username){
		return userMapper.selectByUsername(username);
	}

	@Override
	public int count(User conditions) {
		return userMapper.count(conditions);
	}

	@Override
	public void updatebyId(User user) {
		// TODO Auto-generated method stub
		userMapper.updatebyId(user);
	}

	@Override
	public User selectById(Integer id) {
		return userMapper.selectById(id);
	}


	
}
