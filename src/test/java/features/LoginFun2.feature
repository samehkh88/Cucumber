Feature: Login Module

@One
Scenario Outline: User Can login sucessfully learn
Given the User in home page
When user enter his user "<UserName>" and password "<Password>" and click login
Then the system redirect to the home page and log out appear

Examples:
| UserName | Password | 
| 2same2h1221@netservex.com | Test@123 | 