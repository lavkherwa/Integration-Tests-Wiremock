package com.example.demo.config.mockserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.server.OutboundServiceMockServer;

@Configuration
@Profile("test")
public class MockServerBeanConfig {

	@Bean
	public OutboundServiceMockServer outboundServiceMockServer() {
		return new OutboundServiceMockServer();
	}
}
