Feature:Add Event Functionalities
@wip
  Scenario:Accessing the "Add Event" page
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    Then User can access the "Add Event" page
  @wip
  Scenario:Reachability of "Add Event" button for "Sales Manager" or "Store Manager"
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    Then "Sales Manager" or "Store Manager" can see "Add Event" button
    And "Sales Manager" or "Store Manager" can click "Add Event" button

  @wip
  Scenario:Reachability of "Add Event" button for "Driver"
    Given the user is logged in as "Driver"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    Then "Driver" can NOT see "Add Event" button

  @wip
  Scenario:"Add Event" page pop up.
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    Then "Add Event" page should pop up.


  @wip
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

  @wip
  Scenario:Title field is not filled
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    When fill the compulsory fields with valid values but leave title empty
    And click the save button
    Then "This value should not be blank." message should be displayed

  @wip
  Scenario:Email field is not filled
    Given the user is logged in as "sales manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    When fill the compulsory fields with valid values but leave email empty
    And  click the save button
    Then "This value should not be blank." message should be displayed




  Scenario:Marking the event with any color
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    And  the user can mark the event with any color


  Scenario:"All-day event" button
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    And  clicking on "Add event" button
    And the user can mark "All day event" button


  Scenario:Repeating the action by specifying occurrence periods and ending time
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    When clicking on "Add event" button
    Then Repeat option should includes the options below
      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |

  @ozlem
  Scenario:Repeating the action by specifying occurrence periods and ending time
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    When clicking on "Add event" button
    Then Ends option should be as below
      | Never |
      | After |
      | By    |
    And Ends options should be clickable



  Scenario: Verify the "All Events"
    Given the user is logged in as "store manager"
    And  go to from "Fleet" to "Vehicle" module
    When clicking on any vehicle
    When clicking on "Add event" button
    Then All Users can see all events in the General information page



