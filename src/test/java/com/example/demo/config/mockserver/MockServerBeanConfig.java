package com.example.demo.config.mockserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.server.OutboundServiceMockServer;

@Configuration
public class MockServerBeanConfig {

	@Bean
	@Scope("prototype")
	public OutboundServiceMockServer outboundServiceMockServer(int port) {
		return new OutboundServiceMockServer(port);
	}
}
