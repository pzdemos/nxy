package com.ahead.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.ahead")
@MapperScan("com.ahead.dao")
@SpringBootApplication
public class AppRun {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		SpringApplication.run(AppRun.class,args);
	}

}
