package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.example.demo.server.MockServer;

@Component
public class MockServerInitialization {

	private static List<MockServer> servers = new ArrayList<>();
	
	private MockServerBeanFactory mockServerBeanFactory;

	public MockServerInitialization(MockServerBeanFactory mockServerBeanFactory) {
		this.mockServerBeanFactory = mockServerBeanFactory;

		// Add all the servers which need to be initialized
		addServers();
	}

	private void addServers() {
		servers.add(mockServerBeanFactory.getOutboundServiceMockServer());
	}

	@PostConstruct
	private void initializeServer() {
		servers.stream().forEach((server) -> {
			server.getInstance().start();
			server.initStubs(); 
		});

	}

	@PreDestroy
	private void stopServers() {
		servers.stream().forEach((server) -> {
			if(server.getInstance().isRunning())
			server.getInstance().stop();
		});
	}

}
