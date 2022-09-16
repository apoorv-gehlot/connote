package com.agehlot.connote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ConnoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnoteApplication.class, args);
	}

}
