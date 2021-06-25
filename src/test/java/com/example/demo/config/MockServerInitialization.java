package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.demo.config.mockserver.MockServerBeanFactory;
import com.example.demo.server.base.MockServer;

@Component
@Profile("test")
public class MockServerInitialization {

	private static List<MockServer> serverList = new ArrayList<>();
	
	private MockServerBeanFactory mockServerBeanFactory;

	public MockServerInitialization(MockServerBeanFactory mockServerBeanFactory) {
		this.mockServerBeanFactory = mockServerBeanFactory;

		// Add all the servers which need to be initialized
		addServers();
	}

	private void addServers() {
		serverList.add(mockServerBeanFactory.getOutboundServiceMockServer());
	}

	@PostConstruct
	private void initializeServer() {
		serverList.stream().forEach((server) -> {
			server.getInstance().start();
			server.initStubs(); 
		});

	}

	@PreDestroy
	private void stopServers() {
		serverList.stream().forEach((server) -> {
			if(server.getInstance().isRunning())
			server.getInstance().stop();
		});
	}

}
