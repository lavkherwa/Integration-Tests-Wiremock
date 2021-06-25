package com.example.demo.server.base;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public abstract class MockServerBase implements MockServer{

	private WireMockServer server;
	
	private final String WIREMOCK_BASE_FOLDER = "wiremock-server";

	public MockServerBase(int port) {
		// @formatter:off
 		server = new WireMockServer(WireMockConfiguration
				.wireMockConfig()
				.usingFilesUnderClasspath(WIREMOCK_BASE_FOLDER)
				.port(port));
 		// @formatter:on
	}
	
	@Override
	public WireMockServer getInstance() {
		return server;
	}
}
