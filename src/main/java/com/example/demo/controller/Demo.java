package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OutboundService;

@RestController
@RequestMapping("/")
public class Demo {

	@Value("${outboundSeviceURL}")
	private String serviceURL;

	private OutboundService outboundService;

	public Demo(OutboundService outboundService) {
		this.outboundService = outboundService;

	}

	@RequestMapping("test")
	public String callService() {

		return outboundService.callService(serviceURL, "/test");

	}

}
