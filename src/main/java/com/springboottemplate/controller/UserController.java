package com.springboottemplate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.json.JSONUtils;
import com.springboottemplate.annontation.LogTestAnno;
import com.springboottemplate.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboottemplate.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("user")
	public String findAllUser(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("userList", userService.findAll());
		// 设置了转发的前缀后缀了已经，直接写这个页面即可
		return "list";
	}

	@RequestMapping("userResponseBody")
	@ResponseBody
	public String findAllUser1(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("userList", userService.findAll());
		// 设置了转发的前缀后缀了已经，直接写这个页面即可
		return userService.findAll().toString();
	}

	/**
	 * 直接向页面响应数据
	 * @param request
	 * @param response
	 * @return
	 */
	@LogTestAnno(name="映射得url：findAllUser2")
	@RequestMapping("findAllUser2")
	@ResponseBody
	public String findAllUser2(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("userList", userService.findAll());
		User user=new User();
		user.setArea("qqq");
		user.setName("张三");
		return user.toString();
	}
}
