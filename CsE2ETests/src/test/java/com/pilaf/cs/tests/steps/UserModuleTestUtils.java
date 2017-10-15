package com.pilaf.cs.tests.steps;

import java.util.Collections;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.pilaf.cs.tests.builder.UserTest;

public class UserModuleTestUtils {

	private static final String AUTHORIZATION_TOKEN_FORMAT = "Bearer %s";

	public static MultiValueMap<String, String> getHeaders(UserTest userTest) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.put("Accept", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
		headers.put("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
		headers.put("Authorization",
				Collections.singletonList(String.format(AUTHORIZATION_TOKEN_FORMAT, userTest.getAuthorizationToken())));

		// TODO Auto-generated method stub
		return headers;
	}

}
