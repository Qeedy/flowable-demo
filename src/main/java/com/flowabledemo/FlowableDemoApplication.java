package com.flowabledemo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.flowabledemo.config.FlowableDeployerConfig;

@SpringBootApplication
public class FlowableDemoApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(FlowableDemoApplication.class, args);
		FlowableDeployerConfig deployer = context.getBean(FlowableDeployerConfig.class);
		deployer.deployProcesses();
	}
}
