package com.cts.api.config;



import com.cts.api.filter.TokenValidationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Configuration
public class RouteConfiguration {
	
	private final TokenValidationFilter tokenValidationFilter;
	@Value("${authorization}")
	private String auth;
	@Value("${employee}")
	private String employee;
//	@Value(("${users}"))
//	private String users;
	@Value("${patient}")
	private String patients;
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		log.info("API Route entered");
		return builder.routes()
				.route("auth",ps->ps.path("/auth/**")
				.uri(auth))
				

				.route("employee",ps->ps.path("/employee/**")
				.filters(f->f.filter(tokenValidationFilter))
				.uri(employee))

//				.route("user",ps->ps.path("/user/**")
//						.filters(f->f.filter(tokenValidationFilter))
//						.uri(users))

				.route("patient",ps->ps.path("/patient/**")
						.filters(f->f.filter(tokenValidationFilter))
						.uri(patients)).build();
		

	}
}
