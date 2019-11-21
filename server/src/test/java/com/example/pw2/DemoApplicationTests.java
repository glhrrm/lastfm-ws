package com.example.pw2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URL;

import com.example.pw2.models.Album;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void whenUsingJsonNode_thenOk() throws IOException {
		// URL SOURCE_JSON = new URL(
		// 		"http://ws.audioscrobbler.com/2.0/?method=user.gettopalbums&user=since93&api_key=40824a562c9ab20ff7d4d15766b8b52a&format=json");

		// JsonNode finalNode = new ObjectMapper().readTree(SOURCE_JSON).get("topalbums").get("album");

		// Album album = new Album();
		// album.setName(finalNode.get(0).get("name").textValue());

		// assertEquals(album.getName(), "Funeral");
	}

}
