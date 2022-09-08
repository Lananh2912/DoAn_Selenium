Feature: Them Moi Cong Viec page Quan ly Cong Viec

Scenario Outline: Them moi cong viec tai trang quang ly cong viev

Given user is already login
Then user enters valid "<username>" and "<password>"
Then click on login button 
Then click tag Quan ly cong viec and click button them moi
Then user enter input information cong viec "<tenCongViec>" and "<moTa>" and thong tin khac
And clck button them moi
Then Verify new cong viec is correctly displayed on quan ly cong viec window

Examples:
	| username | password | |tenCongViec|     |moTa|          
	| htha     | 1234 		| | do an1| 					|thuc hien do an|
	
	
Scenario Outline: Tim kiem cong viec tai trang quang ly cong viev

Given user is already login
Then user enters valid "<username>" and "<password>"
Then click on login button 
Then click tag Quan ly cong viec and click button them moi