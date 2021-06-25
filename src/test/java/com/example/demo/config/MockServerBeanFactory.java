package com.example.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.example.demo.server.MockServer;
import com.example.demo.server.OutboundServiceMockServer;

@Component
public class MockServerBeanFactory implements ApplicationContextAware {

	/** application context: holds reference to the bean factory */
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public MockServer getOutboundServiceMockServer() {
		return applicationContext.getBean(OutboundServiceMockServer.class);
	}
}
