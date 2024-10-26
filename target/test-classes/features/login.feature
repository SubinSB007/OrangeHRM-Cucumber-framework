Feature: OrangeHRM login functionality

  Background: navigate to login page
    Given User can navigate to loginpage

  @regression @smoke
  Scenario: Verify login is working with valid credintals
    When User can enter username and password
    Then click on login
    And User can see the home page
    Then Close the driver

  @regression @sanity
  Scenario Outline: Verify login is not working with invalid credintals
    When User can enter "<username>" and "<password>"
    Then click on login
    And invalid credintals message should be seen
    Then Close the driver

    Examples: 
      | username | password |
      | admin    |      123 |
      | adm      | admins   |

  @regression @smoke
  Scenario: Verify logo present int login page
    And User can see ornageHrm logo
    Then Close the driver
