package com.shuklansh.springInitProj.runners;

import com.shuklansh.springInitProj.runners.run.Location;
import com.shuklansh.springInitProj.runners.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class RunnersApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnersApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(RunnersApplication.class, args);
		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
		System.out.println(welcomeMessage.getWelcomeMessage("Ansh"));
	}

	@Bean
	CommandLineRunner runner() { // something that runs after application has started
		return args -> {
			Run run = new Run(
					1,
					"Runner David",
					LocalDateTime.now(),
					LocalDateTime.now().plusHours(2),
					5,
					Location.OUTDOOR);
			log.info("Run : " + run);
		};
	}
}
