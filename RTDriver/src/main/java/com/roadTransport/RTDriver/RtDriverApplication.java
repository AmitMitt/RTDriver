package com.roadTransport.RTDriver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class RtDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtDriverApplication.class, args);
	}

}
