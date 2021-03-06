package com.javainuse;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.javainuse")
@EntityScan("com.javainuse.entity")
@EnableBatchProcessing
@EnableAutoConfiguration
public class SpringBatchChunkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchChunkApplication.class, args);
	}	
}


