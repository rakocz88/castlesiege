Feature: User module feature Feature

#Scenario: I want to log in as a valid user and get a token from the oauth2 service
#	Given I am a user that is not loged in
#	When I try to get a token using the oauth login endpoint and using username = "filip" and password "filip"
#	Then the oauth token should not be empty

Scenario: I want to log in and see my user details
	Given I am a user that is not loged in
	When I try to get a token using the oauth login endpoint and using username = "filip" and password "filip"
	And I try to use the user by name rest enpoint with the username = "filip"
	Then I should get the use with usename = "filip" and the password should not be null	