package com.greatlearning.Debate_Event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.greatlearning.Debate_Event"})
public class DebateEventSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebateEventSpringSecurityApplication.class, args);
		
	}

}
