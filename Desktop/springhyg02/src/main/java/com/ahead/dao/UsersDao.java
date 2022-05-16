package com.ahead.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ahead.bean.Users;

public interface UsersDao {
		@Select("Select * from users where username= #{0}")
		public Users CheckUsername(String username);
		@Select("Select * from users where phone=#{0}")
		public Users CheckPhone(String phone);
		@Select("Select * from users where email=#{0}")
		public Users CheckEmail(String email);
		 @Insert("insert into Users values(null,#{username},#{password},#{email},#{phone})")
		public int Register(Users u);
		@Select("select * from Users where username=#{0} and password=#{1}")
		public Users Login(@Param("0")String username,@Param("1")String password);
}
