package com.pilaf.cs.users.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import com.pilaf.cs.users.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@PropertySource("classpath:test.yml")
// @ContextConfiguration(classes = UserRestController.class)
//@WebMvcTest
public class OAuth2TokenTest {

	@MockBean
	private UserService userService;

//	@Value("${local.server.port}")
//	private int port;

	// @Value("${mielizna}")
	// private int local;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void before() {
		System.out.println("Before");
	}

	// @Test
	// public void tokenLoginTest() throws Exception {
	// when(userService.getAllUsers()).thenReturn(new ArrayList<>());
	// mvc.perform(get("/all")).andExpect(status().isOk());
	// System.out.println("Hello");
	// }

//	protected OAuth2ProtectedResourceDetails resource() {
//
//		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
//
//		List<String> scopes = new ArrayList<String>(2);
//		scopes.add("write");
//		scopes.add("read");
//		resource.setAccessTokenUri("http://localhost:" + port + "/users/oauth/token");
//		resource.setClientId("cs");
//		resource.setClientSecret("secret");
//		resource.setGrantType("password");
//		resource.setScope(scopes);
//
//		resource.setUsername("filip");
//		resource.setPassword("filip");
//
//		return resource;
//	}

	@Test
	public void testOauth2() throws Exception {
		getAccessToken("filip", "filip");
//		AccessTokenRequest atr = new DefaultAccessTokenRequest();
//		OAuth2RestOperations restTemplate = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
//		restTemplate.getAccessToken();
	}

	private String getAccessToken(String username, String password) throws Exception {
		String authorization = "Basic "
				+ new String(Base64Utils.encode("clientapp:123456".getBytes()));
		String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

		// @formatter:off
		String content = mockMvc
				.perform(
						post("/users/oauth/token")
								.header("Authorization", authorization)
								.contentType(
										MediaType.APPLICATION_FORM_URLENCODED)
								.param("username", username)
								.param("password", password)
								.param("grant_type", "password")
								.param("scope", "read write")
								.param("client_id", "cs")
								.param("client_secret", "secret"))
				.andExpect(status().isOk())
//				.andExpect(content().contentType(contentType))
//				.andExpect(jsonPath("$.access_token", is(notNullValue())))
//				.andExpect(jsonPath("$.token_type", is(equalTo("bearer"))))
//				.andExpect(jsonPath("$.refresh_token", is(notNullValue())))
//				.andExpect(jsonPath("$.expires_in", is(greaterThan(4000))))
//				.andExpect(jsonPath("$.scope", is(equalTo("read write"))))
				.andReturn().getResponse().getContentAsString();

		// @formatter:on

		return content.substring(17, 53);
	}
}