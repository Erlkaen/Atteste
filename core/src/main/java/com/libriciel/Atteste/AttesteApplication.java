package com.libriciel.Atteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AttesteApplication {
	public static void main(String[] args) {
		SpringApplication.run(AttesteApplication.class, args);
	}	
}
