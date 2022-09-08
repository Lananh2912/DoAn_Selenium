Feature: Login page Quan ly Cong Viec


Scenario Outline: Login page quang ly cong viec with input valid

Given user is already on Login Page
When title of login page is Quan Ly cong Viec
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home pag

Examples:
	| username | password |
	| htha     | 1234 		| 