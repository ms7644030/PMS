package com.pensionerDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@EnableEurekaClient
@SpringBootApplication
public class PensionerDetailServiceApplication {
	
		
	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailServiceApplication.class, args);
		
		
	
	}



}
