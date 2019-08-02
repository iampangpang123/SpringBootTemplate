package com.springboottemplate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboottemplate.pojo.User;
@Mapper
public interface UserMapper {

	
	public List<User> findAll();
}
