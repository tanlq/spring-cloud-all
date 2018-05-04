package com.blomni.o2o.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="blomni-cloud-EurekaClient/blomni-o2o/erk") 
public interface ComputeClient {
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public Integer add(@RequestParam(value = "a") Integer a,@RequestParam(value = "b") Integer b);

}
