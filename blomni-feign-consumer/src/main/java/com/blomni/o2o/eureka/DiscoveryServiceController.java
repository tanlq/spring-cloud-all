	package com.blomni.o2o.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blomni.o2o.eureka.service.ComputeClient;

@RestController
public class DiscoveryServiceController {

	@Autowired
	ComputeClient computeClientService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
		System.out.println("进来了");
        return computeClientService.add(50, 20);
    }
}
