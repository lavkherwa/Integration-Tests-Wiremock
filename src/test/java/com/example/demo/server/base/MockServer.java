package com.example.demo.server.base;

import com.github.tomakehurst.wiremock.WireMockServer;

public interface MockServer {
	
	public void initStubs();
	public WireMockServer getInstance();
	
}
