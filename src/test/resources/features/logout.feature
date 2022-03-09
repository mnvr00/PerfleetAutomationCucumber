Feature: LogOut Functionalities
  Background:
    Given the user is on the login page

@PERF-865 @logout
Scenario: User can log out
  Given "User" can log out by using log out button inside profile info and ends up in login page.

@PERF-866 @logout
Scenario:The user can not go to the home page again
  Given The "user" can not go to the home page again by clicking the step back button after successfully logged out.

@PERF-867 @logout
Scenario: The user must be logged out if the user close the tab
  Given The "user" must be logged out if the user close the tab (if there are multiple open tabs in the app, close all of them)

@PERF-868 @logout
Scenario: Keyboard
  Given The "user" must be logged out if the user is away from keyboard for three minutes