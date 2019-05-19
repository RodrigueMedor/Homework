package com.MyProductsMgmtWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MyProductsMgmtWebAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyProductsMgmtWebAppApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(MyProductsMgmtWebAppApplication.class);
	}
}
