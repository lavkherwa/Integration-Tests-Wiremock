package com.example.demo.server;

import com.github.tomakehurst.wiremock.WireMockServer;

public interface MockServer {
	
	public void initStubs();
	public WireMockServer getInstance();
	
}
