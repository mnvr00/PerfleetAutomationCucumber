Feature: Login Functionalities
  Background:
    Given the user is on the login page

 @PERF-812 @login
 Scenario Outline:entering with valid credentials
   Then the user enter "<valid username>" and "<valid password>"
  Examples:
  |valid username   |valid password   |
  |user5            |UserUser123      |
  |salesmanager101  |UserUser123      |
  |storemanager85   |UserUser123      |

  @PERF-813 @login
 Scenario: after valid credentials
   Then "Driver" should land on the "Quick Launchpad" page after successful login
   Then "Sales Manager" or "Store Manager" should land on the "Dashboard" page after successful login

  @PERF-814 @login
  Scenario: The system shouldn't allow users to access the application without providing credentials
    Given copy the url after log in then log out paste the same url to browser and try to skip authentication step

  @PERF-815 @login
  Scenario Outline:entering with invalid credentials
    Then the user enters invalid credentials "<invalid username>" and "<invalid password>" and after "Invalid username or password." message should be displayed for invalid credentials
    Examples:
      |invalid username |invalid password|
      |user5            |1234567       |
      |abcdefg          |UserUser123   |
      |salesmanager101  |dnjd3445      |

  @PERF-816 @login
  Scenario Outline:entering with blank credentials
    Then the user enters blank credentials "<blank username>" and "<blank password>" and  "Please fill out this field." message should be displayed for any empty field
    Examples:
      |blank username   |blank password|
      |user5            |              |


  @PERF-817 @login
  Scenario: bullet sign
    Given Users should see their password in bullet signs while typing

  @PERF-818 @login
  Scenario:Forgot Password menu
    Then User lands on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
    Then Users can change their password with the username after clicking on "Forgot your password?" link

  @PERF-819 @login
  Scenario: Remember me on this computer link
      Given User can see "Remember me on this computer" link on the login page and it should be clickable

  @PERF-820 @login
   Scenario:User can use "Enter" key
     Given User can use "Enter" key from their keyboard on the login page after entering username and password

  @PERF-821 @login
  Scenario: drivers can see their own usernames
      Given drivers can see own username in profile menu, after successful login

  @PERF-822 @login
  Scenario: sales manager can see their own usernames
    Given sales manager can see own username in profile menu, after successful login

  @PERF-823 @login
  Scenario: store manager can see their own usernames
    Given store manager can see own username in profile menu, after successful login










