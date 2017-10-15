package com.pilaf.cs.tests.builder;

public class UserTest {

	private String login;
	private String password;
	private String authorizationToken;
	private String returnedUser;
	private static UserTest instance = null;

	private UserTest() {
		super();
	}

	public static UserTest getInstance() {
		if (instance == null) {
			instance = new UserTest();
		}
		return instance;
	}

	public static UserTest resetData() {
		instance = new UserTest();
		return instance;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

	public String getReturnedUser() {
		return returnedUser;
	}

	public void setReturnedUser(String returnedUser) {
		this.returnedUser = returnedUser;
	}

}
