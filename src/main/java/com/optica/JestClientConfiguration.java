package com.optica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

@Configuration
public class JestClientConfiguration {

	private final Logger logger = LoggerFactory.getLogger(JestClientConfiguration.class);
	
	@Bean
	public JestClient jestClient() throws Exception {

		String connectionUrl;

		if (System.getenv("SEARCHBOX_URL") != null) {
			// Heroku
			logger.info("[HEROKU AUTHENTICATION]");
			connectionUrl = System.getenv("SEARCHBOX_URL");

		}else {
			logger.info("[SOURCE UNSAFE AUTHENTICATION]");
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
