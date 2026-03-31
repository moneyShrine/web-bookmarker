package com.webbookmarker;

import org.springframework.boot.SpringApplication;

public class TestWebbookmarkerApplication {

	public static void main(String[] args) {
		SpringApplication.from(WebbookmarkerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
