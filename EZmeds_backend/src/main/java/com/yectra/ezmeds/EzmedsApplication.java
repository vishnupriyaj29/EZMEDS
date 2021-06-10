package com.yectra.ezmeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
@EnableMongoAuditing
@SpringBootApplication
public class EzmedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzmedsApplication.class, args);
	}

}
