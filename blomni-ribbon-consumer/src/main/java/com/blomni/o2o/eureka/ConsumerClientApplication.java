/**
 * @(#)OrderApplication.java, 十月 11, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.blomni.o2o.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 应用服务启动类，启动带配置选项 -dev -pre -prod 会根据配置选项读取不同环境的配置文件以cloud-osp开始，以参数结尾 eg. :
 * cloud-osp-dev 启动参数加上 --config.profile=dev (开发) 读取 cloud-osp-dev.properties
 * --config.profile=test(测试) 读取 cloud-osp-test.properties
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableAutoConfiguration
@EnableCircuitBreaker  //使用断路器
public class ConsumerClientApplication {

	@Bean
	// 定义REST客户端，RestTemplate实例
	@LoadBalanced
	// 开启负债均衡的能力
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {

		SpringApplication.run(ConsumerClientApplication.class, args);

	}
}
