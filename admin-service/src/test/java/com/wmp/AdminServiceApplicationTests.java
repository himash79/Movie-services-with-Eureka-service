package com.wmp;

import com.wmp.dto.AuthRequest;
import com.wmp.entity.Episode;
import com.wmp.entity.Location;
import com.wmp.entity.Movie;
import com.wmp.entity.Origin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
class AdminServiceApplicationTests {

	private String baseUrl = "http://localhost:8090/admin-service/api";
	private HttpHeaders headers = new HttpHeaders();
	private RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	private static String access_token;
	private static String client = "user01";
	private static String secret = "1111";

	@Test
	void authenticate() {
		AuthRequest authReq = new AuthRequest(client, secret);
		HttpEntity<AuthRequest> entity = new HttpEntity<>(authReq, headers);
		ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(baseUrl+"/authenticate", HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, String>>() {
		});
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
		assertThat(responseEntity.getBody().containsKey("token"), is(true));
		access_token = responseEntity.getBody().get("token");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + access_token);
	}

	@Test
	void findAllMovies() {
		AuthRequest authReq = new AuthRequest(client, secret);
		HttpEntity<AuthRequest> entity = new HttpEntity<>(authReq, headers);
		ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(baseUrl+"/authenticate", HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, String>>() {
		});
		access_token = responseEntity.getBody().get("token");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + access_token);

		HttpEntity entity_fetchAll = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity_fetchAll = restTemplate.exchange(baseUrl+"/movies", HttpMethod.GET, entity_fetchAll, new ParameterizedTypeReference<>() {
		});
		assertThat(responseEntity_fetchAll.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	void insertMovie() {
		AuthRequest authReq = new AuthRequest(client, secret);
		HttpEntity<AuthRequest> entity = new HttpEntity<>(authReq, headers);
		ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(baseUrl+"/authenticate", HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, String>>() {
		});
		access_token = responseEntity.getBody().get("token");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + access_token);

		Movie m = new Movie("Alive","david Smith_2","2017-11-04T18:50:21.651Z","Human",
				"https://rickandmortyapi.com/api/character/2", "","Male",
				"https://rickandmortyapi.com/api/character/avatar/2.jpeg", null, null, null);

		Origin o = new Origin("Earth","https://rickandmortyapi.com/api/location/1");
		Location l = new Location("Earth", "https://rickandmortyapi.com/api/location/1");
		Episode e = new Episode("Active","John Doe","https://example.com/characters/1");
		Set<Episode> listEpisode = new HashSet<>();
		listEpisode.add(e);

		m.setOrigin(o);
		m.setLocation(l);
		m.setEpisodes(listEpisode);

		HttpEntity entity_insert = new HttpEntity<>(m, headers);
		ResponseEntity<String> responseEntity_insert = restTemplate.exchange(baseUrl+"/movies", HttpMethod.POST, entity_insert, new ParameterizedTypeReference<>() {
		});

		assertThat(responseEntity_insert.getStatusCode(), is(HttpStatus.CREATED));
	}

	@Test
	void removeMovie() {
		AuthRequest authReq = new AuthRequest(client, secret);
		HttpEntity<AuthRequest> entity = new HttpEntity<>(authReq, headers);
		ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(baseUrl+"/authenticate", HttpMethod.POST, entity, new ParameterizedTypeReference<>() {
		});
		access_token = responseEntity.getBody().get("token");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + access_token);
		int movieId = 53;
		HttpEntity entity_remove = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity_remove = restTemplate.exchange(baseUrl+"/movies/"+movieId, HttpMethod.DELETE, entity_remove, new ParameterizedTypeReference<>() {
		});

		assertThat(responseEntity_remove.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	void updateMovie() {
		AuthRequest authReq = new AuthRequest(client, secret);
		HttpEntity<AuthRequest> entity = new HttpEntity<>(authReq, headers);
		ResponseEntity<Map<String, String>> responseEntity = restTemplate.exchange(baseUrl+"/authenticate", HttpMethod.POST, entity, new ParameterizedTypeReference<>() {
		});
		access_token = responseEntity.getBody().get("token");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + access_token);

		// todo - For HTTP.PATCH
		Movie m = new Movie();
		m.setType("mode 01");

		// todo - For HTTP.PUT
//		Movie m = new Movie("Alive","david Smith_2","2017-11-04T18:50:21.651Z","Meta-Human",
//				"https://rickandmortyapi.com/api/character/2", "","Female",
//				"https://rickandmortyapi.com/api/character/avatar/2.jpeg", null, null, null);
//
//		Origin o = new Origin("Earth","https://rickandmortyapi.com/api/location/1");
//		Location l = new Location("Earth", "https://rickandmortyapi.com/api/location/1");
//		Episode e = new Episode("Active","John Doe","https://example.com/characters/1");
//		Set<Episode> listEpisode = new HashSet<>();
//		listEpisode.add(e);
//
//		m.setOrigin(o);
//		m.setLocation(l);
//		m.setEpisodes(listEpisode);

		int movieId = 107;

		HttpEntity entity_update = new HttpEntity<>(m, headers);
		ResponseEntity<String> responseEntity_update = restTemplate.exchange(baseUrl+"/movies/updateMovie/"+movieId, HttpMethod.PATCH, entity_update, new ParameterizedTypeReference<>() {
		});

		assertThat(responseEntity_update.getStatusCode(), is(HttpStatus.CREATED));

	}
}
