package com.madushan.book.publishing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Validated
public class BookPublishingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPublishingApplication.class, args);
	}

}
