package coms.Admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import coms.Admin.controller.AdminController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@ComponentScan
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
		
		@LoadBalanced
		@Bean
		public RestTemplate fetchRestTemplate() {
			return new RestTemplate();
		}
	}


