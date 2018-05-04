package com.blomni.o2o.es.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blomni.o2o.es.bean.Entity;
import com.blomni.o2o.es.repository.CityESService;



@RestController
public class Hbcontroller {

	private static Logger logs = LoggerFactory.getLogger(Hbcontroller.class);

	@Autowired
	private CityESService cityESService;

	

	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public String search(HttpServletRequest request) {
		String name=request.getParameter("name");
		List<Entity> ls=cityESService.searchEntity(name);
		
		return com.alibaba.fastjson.JSONObject.toJSONString(ls);
	}
	
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request) {
		logs.info("我在测试王一一一一一一一  ");
		logs.info("输出info  ");
		logs.debug("输出debug+skkkw嗡嗡嗡kw");
		logs.error("输出error  嗡嗡嗡我");
		logs.warn("输出error  嗡嗡嗡我");
		return "返回了";
	}
	
}
