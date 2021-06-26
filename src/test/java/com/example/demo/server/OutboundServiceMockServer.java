package com.example.demo.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.demo.server.base.MockServerBase;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class OutboundServiceMockServer extends MockServerBase {

	public OutboundServiceMockServer(int port) {
		super(port);
	}

	@Override
	public void initStubs() {
		addStringStub();
		addJsonStub();
	}

	private void addStringStub() {
		// @formatter:off
		this.getInstance().stubFor(WireMock
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
		this.getInstance().stubFor(WireMock
				.get("/testJson")
				.willReturn(new ResponseDefinitionBuilder()
									.withHeader("content-Type", MediaType.APPLICATION_JSON_VALUE)
									.withBodyFile("test-json.handlebars")
									.withStatus(HttpStatus.OK.value())
									.withFixedDelay(1000) // respond after 1 seconds, useful for circuit breaker scenario testing
									.withTransformers("response-template")));
		// @formatter:on
	}

}
