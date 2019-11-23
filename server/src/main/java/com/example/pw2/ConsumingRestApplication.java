package com.example.pw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumingRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	// @Bean
	// public RestTemplate restTemplate(RestTemplateBuilder builder) {
	// 	return builder.build();
	// }

	// @Bean
	// public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	// 	URL source = new URL("http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=since93&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");
	// 	JsonNode finalNode = new ObjectMapper().readTree(source).get("topalbums").get("album");

	// 	return args -> {
	// 		for (JsonNode objNode : finalNode) {
	// 			Album album = new ObjectMapper().treeToValue(objNode, Album.class);
	// 			System.out.println(album);
	// 		}
	// 	};
	// }
}