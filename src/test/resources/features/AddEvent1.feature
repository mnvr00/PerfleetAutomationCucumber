Feature:Add Event Functionalities

  Scenario:Accessing the "Add Event" page
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    Then User can access the "Add Event" page

  Scenario:Reachability of "Add Event" button for "Sales Manager" or "Store Manager"
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    Then "Sales Manager" or "Store Manager" can see "Add Event" button
    And "Sales Manager" or "Store Manager" can click "Add Event" button


  Scenario:Reachability of "Add Event" button for "Driver"
    Given the user is logged in as "Driver"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    Then "Driver" can NOT see "Add Event" button


  Scenario:"Add Event" page pop up.
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    Then "Add Event" page should pop up.


  Scenario:After logout, add event page still appear
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    And user logout
    When the user is logged in as "sales manager"
    Then add event page still appear there


  Scenario:Compulsory fields
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And clicking on "Add event" button
    Then Compulsory fields are shown as below:
      |Title*                 |
      |Owner*                 |
      |Organizer display name*|
      |Organizer email*       |
      |Start*                 |
      |End*                   |

@munevver
  Scenario:Title field is not filled
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    When fill the compulsory fields with valid values but leave title empty
    And click the save button
    Then "This value should not be blank." message should be displayed


  Scenario:Email field is not filled
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    When fill the compulsory fields with valid values but leave email empty
    And  click the save button
    Then "This value should not be blank." message should be displayed

