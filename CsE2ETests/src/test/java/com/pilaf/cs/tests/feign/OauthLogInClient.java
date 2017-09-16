package com.pilaf.cs.tests.feign;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OauthLogInClient {

	private static final String OAUTH_TOKEN_URL = "http://localhost:8080/oauth/token";

	@Autowired
	private RestTemplate restTemplate;
	
    private static final String GRANT_TYPE = "password";

	@SuppressWarnings("rawtypes")
	public String getOauthRequestToken(String user, String password) {
		ResponseEntity<Map> result = restTemplate.postForEntity(OAUTH_TOKEN_URL+"?grant_type="
				+ GRANT_TYPE + "&username=" + user + "&password=" + password, null, Map.class);
		return (String) result.getBody().get("access_token");
	}
}