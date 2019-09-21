package com.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean findUserById(String param, Integer type) {
		
		String colum=(type==1)?"username":(type==2?"phone":"email");
		/*
		 * QueryWrapper<User> queryWrapper =new QueryWrapper<>(); queryWrapper.eq(colum,
		 * param); User user = userMapper.selectOne(queryWrapper);
		 */
		User user2=userMapper.findUserById(colum,param);
		return user2==null?false:true;
	}
	
	
	
}
