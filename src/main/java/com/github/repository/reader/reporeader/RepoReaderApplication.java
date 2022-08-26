package com.github.repository.reader.reporeader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RepoReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoReaderApplication.class, args);
	}

}