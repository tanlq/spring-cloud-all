package com.blomni.o2o.eureka;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HbController {

	private static Logger logs = LoggerFactory.getLogger(HbController.class);

	// Eureka客户端
	/*@Autowired
	private EurekaClient eurekaClient;*/

	@Autowired
	private DiscoveryClient discoveryClient; // 服务发现客户端

	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request,@RequestBody String param) {
		
//		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
//		logs.info("/test1, host:" + instance.getHost() + ", service_id:"
//				+ instance.getServiceId());
		return param;
	}
	
	@RequestMapping(value = "/test2",method=RequestMethod.GET)
	public String test2(HttpServletRequest request) {
		
//		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
//		logs.info("/test1, host:" + instance.getHost() + ", service_id:"
//				+ instance.getServiceId());
		return request.getParameter("name");
	}

	/**
	 * 获得Eureka instance的信息，传入Application NAME
	 * 
	 * */
	/*@RequestMapping(value = "/eureka-instance", method = { RequestMethod.GET })
	public String serviceUrl() {
		InstanceInfo instance = this.eurekaClient.getNextServerFromEureka(
				"MICROSERVICE-PROVIDER-USER", false);
		return instance.getHomePageUrl();
	}*/

	/**
	 * 本地服务实例信息
	 * */
	@RequestMapping(value = "/instance-info", method = { RequestMethod.GET })
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient
				.getLocalServiceInstance();
		return localServiceInstance;
	}

	@GetMapping(value = "/add")
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		Integer r = a + b;
		logs.info("/add, host:" + instance.getHost() + ", service_id:"
				+ instance.getServiceId() + ", result:" + r);
		return r;
	}

}
