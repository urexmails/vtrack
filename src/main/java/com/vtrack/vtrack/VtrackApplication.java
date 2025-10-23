package com.vtrack.vtrack;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vtrack.vtrack")
public class VtrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtrackApplication.class, args);
	}

}
