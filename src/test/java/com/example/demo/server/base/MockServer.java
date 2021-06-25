package com.example.demo.server.base;

import com.github.tomakehurst.wiremock.WireMockServer;

public interface MockServer {

	/**
	 * Initialize the stubs
	 */
	public abstract void initStubs();

	/**
	 * get mock server instance
	 * 
	 * @return WireMockServer
	 */
	public WireMockServer getInstance();
}
