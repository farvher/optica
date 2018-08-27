package com.optica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

@Configuration
public class JestClientConfiguration {

	@Bean
	public JestClient jestClient() throws Exception {

		String connectionUrl;

		if (System.getenv("SEARCHBOX_URL") != null) {
			// Heroku
			connectionUrl = System.getenv("SEARCHBOX_URL");

		}else {
			// generic, check your dashboard
			connectionUrl = "http://paas:46c30b910289afebc6779d086e742abd@thorin-us-east-1.searchly.com";
			// connectionUrl = "http://localhost:9200"
		}

		// Configuration
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(connectionUrl).multiThreaded(true).build());
		return factory.getObject();
	}
}
