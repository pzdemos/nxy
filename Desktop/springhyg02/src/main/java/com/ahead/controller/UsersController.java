package com.ahead.controller;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahead.bean.Users;
import com.ahead.dao.UsersDao;

@Controller
public class UsersController {
	@Autowired//自动写入
	UsersDao usersDao;

	@RequestMapping("/CheckPhone")
	@ResponseBody
	public Boolean CheckPhone(String phone) {
		Users p=usersDao.CheckPhone(phone);
		if(p == null) {
			return true;
		}else {

			return false;
		}
	}

	@RequestMapping("/CheckEmail")
	@ResponseBody
	public Boolean CheckEmail(String email) {
		Users e=usersDao.CheckEmail(email);
		if(e == null) {
			return true;
		}else {

			return false;
		}
	}

	@RequestMapping("/CheckUsername")
	@ResponseBody
	public Boolean CheckUsername(String username) {
		Users u=usersDao.CheckUsername(username);
		if(u == null) {
			return true;
		}else {

			return false;
		}
	}
	@RequestMapping("/DoRegister")
	public String Register(Users u) {
		int row =usersDao.Register(u);
		System.out.println("共"+row+"行受影响");
		return "redirect:login.html";

	}

	@RequestMapping("/DoLogin")
	public String login(Map<String,Object>map,String username,String password) {
		Users u=usersDao.Login(username,password);
		if(u!=null) {

			return "redirect:success.html";
		}else {
			map.put("msg","用户密码错误");
			return "login1";
		}

	}



}
