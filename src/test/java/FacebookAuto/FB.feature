Feature: Facebook Account Creation

Scenario Outline: Navigate to facebook
Given User navigates to the facebook URL "https://www.facebook.com"
When User needs to click on English Language
When User need to click on create account button
When User needs to land on account details page
When User needs to enter his <FirstName> and <SurName>
When User needs to enter his email<email_address>
When User needs to Reenter his Email<ReEmail>
When User needs to enter his pass<Password>

When User needs to select his <day> and <month> and <year>
When User needs to select his gender<gender>
Then User should be able to create account

Examples: 
|FirstName|SurName|email_address	|ReEmail				|Password	|day|month|year|gender|
|aaa			|bbb		|aaabb@gmail.com|aaabb@gmail.com|aaabb@11	|11	|Jul	|2015|Male	|
|qqq			|www		|qqq@gmail.com	|qqq@gmail.com  |qqq@12		|28	|Jan	|1995|Female|


