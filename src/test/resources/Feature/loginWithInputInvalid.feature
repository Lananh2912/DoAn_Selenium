Feature: Login page Quan ly Cong Viec


Scenario Outline: Login page quang ly cong viec with input invalid

Given user is already on Login Page quuan ly cong viec
Then user enters input invalid "<username>" and "<password>"
Then user clicks on đăng nhâp button
Then Ui is show validatioon

Examples:
	| username | password |
	| htha1    | 1234 		| 
	| htha     | 12345    |
	| htha1		 | 12345    | 