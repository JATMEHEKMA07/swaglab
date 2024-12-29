Feature: Login functionality


@SMOKE
Scenario: To check login functionality working


When enter valid username and password
And click on login button 
Then user should login and navigate to homepage