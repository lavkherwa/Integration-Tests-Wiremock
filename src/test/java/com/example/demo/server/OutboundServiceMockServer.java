package com.example.demo.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

@Component
public class OutboundServiceMockServer implements MockServer {

	private WireMockServer server;

	public OutboundServiceMockServer() {
		// @formatter:off
 		server = new WireMockServer(WireMockConfiguration
				.wireMockConfig()
				.port(8080));
 		// @formatter:on
	}

	@Override
	public void initStubs() {
		addSimpleStub();
		addJsonStub();
	}

	@Override
	public WireMockServer getInstance() {
		return server;
	}
	
	
	private void addSimpleStub() {
		// @formatter:off
		server.stubFor(WireMock
				.get("/test")
				.atPriority(1)
				.willReturn(new ResponseDefinitionBuilder()
									.withHeader("content-Type", MediaType.APPLICATION_JSON_VALUE)
									.withStatus(HttpStatus.OK.value())
									.withBody("Hello World")));
		// @formatter:on
	}
	
	private void addJsonStub() {
		// @formatter:off
		server.stubFor(WireMock
				.get("/testJson")
				.willReturn(new ResponseDefinitionBuilder()
									.withHeader("content-Type", MediaType.APPLICATION_JSON_VALUE)
									.withStatus(HttpStatus.OK.value())
									.withBody("Hello World")));
		// @formatter:on
	}
}
