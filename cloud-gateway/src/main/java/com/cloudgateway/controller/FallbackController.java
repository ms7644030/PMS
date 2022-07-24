package com.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import reactor.core.publisher.Mono;

//@RestController
public class FallbackController {
	/*
	//@HystrixCommand(fallbackMethod = "pensionerDetailFallBack")
	@RequestMapping("/pdFallBack")
	public Mono<String> pensionerDetailFallBack(){
		
		return Mono.just("Pensioner Detail Service is taking too long to respond or is down. Please try again later");
	}
	
	@RequestMapping("/ppFallBack")
	public Mono<String> processPensionFallBack(){
		
		return Mono.just("Process Pension Service is taking too long to respond or is down. Please try again later");
	}
*/
}
