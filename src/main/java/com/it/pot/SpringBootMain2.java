package com.it.pot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author javahunk
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringBootMain2 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain2.class, args);
	}
}
