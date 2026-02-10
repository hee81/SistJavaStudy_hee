package com.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.boot.controller"})
public class SpringbootEx2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEx2Application.class, args);
	}

}
