package com.connect.tea.connecttea.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.connect.tea.connecttea")
@EnableJpaRepositories(basePackages = "com.connect.tea.connecttea.repository")
@EntityScan(basePackages = "com.connect.tea.connecttea.model")
public class ConnectTeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectTeaApplication.class, args);
	}

}
