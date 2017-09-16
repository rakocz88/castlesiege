Feature: User module feature Feature

Scenario: I want to log in as a valid user and get a token from the oauth2 service
	Given I am a user that is not loged in
	When I try to get a token using the oauth login endpoint and using username = "filip" and password "filip"
	Then the oauth token should not be empty
	