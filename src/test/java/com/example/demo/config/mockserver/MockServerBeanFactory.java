package com.example.demo.config.mockserver;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.demo.server.OutboundServiceMockServer;
import com.example.demo.server.base.MockServer;

@Component
@Profile("test")
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
