/**
 * @(#)OrderApplication.java, 十月 11, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.blomni.o2o.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 应用服务启动类，启动带配置选项 -dev -pre -prod 会根据配置选项读取不同环境的配置文件以cloud-osp开始，以参数结尾 eg. :
 * cloud-osp-dev 启动参数加上 --config.profile=dev (开发) 读取 cloud-osp-dev.properties
 * --config.profile=test(测试) 读取 cloud-osp-test.properties
 */
@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableEurekaClient
public class EurekaClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaClientApplication.class, args);

	}
}
