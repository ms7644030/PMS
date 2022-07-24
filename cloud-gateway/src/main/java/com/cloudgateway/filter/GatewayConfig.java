package com.cloudgateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	@Autowired
	private AuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		
		return builder.routes().route("pensioner-detail-service", r -> r.path("/pensionerDetail/**").filters(f -> f.filter(filter)).uri("lb://PENSIONER-DETAIL-SERVICE"))
				.route("process-pension", r -> r.path("/processPension/**").filters(f -> f.filter(filter)).uri("lb://PROCESS-PENSION-SERVICE")).build();
				
	}

}
