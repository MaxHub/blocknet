package com.blocknet.p2p;

import com.blocknet.p2p.service.StartAction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class P2pApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(P2pApplication.class, args);
		context.getBean(StartAction.class).start();
	}
}
