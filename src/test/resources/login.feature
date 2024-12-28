Feature: Login

  Scenario Outline: Validate user is able to login
    Given I opened the Page using <URL>
    When I have the <username> and <password>
    Then Perform Login
    And Verify the current url contains <Target>
    And the page contains Logged In Successfully
    Then Logout

    Examples: 
      | URL                                                     | username | password    | Target                                             |
      | https://practicetestautomation.com/practice-test-login/ | student  | Password123 | practicetestautomation.com/logged-in-successfully/ |

  Scenario Outline: Negative User Login
    Given I opened the Page using <URL>
    When I have the <username> and <password>
    Then Perform Login
    And Validate the page displays an <Message>

    Examples: 
      | URL                                                     | username      | password    | Message                   |
      | https://practicetestautomation.com/practice-test-login/ | incorrectUser | Password123 | Your username is invalid! |

  Scenario Outline: Negative User Password Login
    Given I opened the Page using <URL>
    When I have the <username> and <password>
    Then Perform Login
    And Validate the page displays an <Message>

    Examples: 
      | URL                                                     | username | password          | Message                   |
      | https://practicetestautomation.com/practice-test-login/ | student  | incorrectPassword | Your password is invalid! |
