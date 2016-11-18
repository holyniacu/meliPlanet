package com.meli;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.meli", "com.meli.domain"})
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
		InitTask task = app.getBean(InitTask.class);
		task.init();
	}

}
