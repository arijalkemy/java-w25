package com.mercadolibre.bootcamp_demo_java_app.controller;

import com.newrelic.api.agent.NewRelic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

	@GetMapping("/ping")
	public String ping() {
		System.out.println("Le pego al endpoint");
		NewRelic.ignoreTransaction();
		return "pong";
	}
}
