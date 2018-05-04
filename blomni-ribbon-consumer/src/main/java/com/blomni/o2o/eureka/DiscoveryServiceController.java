	package com.blomni.o2o.eureka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DiscoveryServiceController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/discovery")
	public String doDiscoveryService() {
		StringBuilder buf = new StringBuilder();
		List<String> serviceIds = discoveryClient.getServices();
		if (!CollectionUtils.isEmpty(serviceIds)) {
			for (String s : serviceIds) {
				System.out.println("serviceId:" + s);
				List<ServiceInstance> serviceInstances = discoveryClient
						.getInstances(s);
				if (!CollectionUtils.isEmpty(serviceInstances)) {
					for (ServiceInstance si : serviceInstances) {
						buf.append("[" + si.getServiceId() + " host="
								+ si.getHost() + " port=" + si.getPort()
								+ " uri=" + si.getUri() + "]");
					}
				} else {
					buf.append("no service.");
				}
			}
		}

		return buf.toString();
	}

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public String getServiceMethod() {
		List<ServiceInstance> serviceInstanceList = discoveryClient
				.getInstances("blomni-cloud-EurekaClient");

		StringBuilder stringBuilder = new StringBuilder();

		java.net.URI uri = null;

		for (ServiceInstance instance : serviceInstanceList) {

			stringBuilder.append("host=" + instance.getHost());

			stringBuilder.append("port=" + instance.getPort());

			stringBuilder.append("serviceId=" + instance.getServiceId());

			stringBuilder.append("uri=" + instance.getUri());

			stringBuilder.append("\n");

			uri = instance.getUri();

		}

		String uriString = uri.toString() + "/blomni-o2o/erk/add?a=10&b=20";

		stringBuilder.append("response body="
				+ restTemplate.getForEntity(uriString, String.class).getBody());

		return stringBuilder.toString();
	}

	@GetMapping(value = "/add")
	@HystrixCommand(fallbackMethod = "addServiceFallback")  
	public String add() {
		return restTemplate.getForEntity("http://blomni-cloud-EurekaClient/add?a=10&b=20", String.class).getBody();
	}

	public String addServiceFallback() {  
        return "error";  
    } 
}
