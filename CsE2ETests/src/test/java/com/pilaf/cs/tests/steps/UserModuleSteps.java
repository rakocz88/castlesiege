package com.pilaf.cs.tests.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.springframework.beans.factory.annotation.Autowired;

import com.pilaf.cs.tests.SpringIntegrationTest;
import com.pilaf.cs.tests.builder.UserTest;
import com.pilaf.cs.tests.feign.OauthLogInClient;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;;

public class UserModuleSteps extends SpringIntegrationTest {

	@Autowired
	private OauthLogInClient oauthLogInClient;

	private UserTest userTest;

	@Given("^I am a user that is not loged in$")
	public void i_am_a_user_that_is_not_loged_in() throws Throwable {
		userTest = new UserTest();
	}

	@When("^I try to get a token using the oauth login endpoint and using username = \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_try_to_get_a_token_using_the_oauth_login_endpoint_and_using_username_and_password(String user,
			String password) throws Throwable {
		String token = oauthLogInClient.getOauthRequestToken(user, password);
		userTest.setAuthorizationToken(token);
	}

	@Then("^the oauth token should not be empty$")
	public void the_oauth_token_should_not_be_empty() throws Throwable {
		assertThat(userTest.getAuthorizationToken(), is(not(isEmptyOrNullString())));
		;
	}

}
