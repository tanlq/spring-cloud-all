package com.blomni.o2o.eureka;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HbController {

	private static Logger logs = LoggerFactory.getLogger(HbController.class);

	@Value("${profile}")
	private String profile;

	@RequestMapping(value = "/from", method = { RequestMethod.GET })
	public String test(HttpServletRequest request) {
		
		return profile;
	}

}
