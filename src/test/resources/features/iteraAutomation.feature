Feature: Allow User to fill test automation practice form

  Scenario: User enters valid details in textarea practice section
    When User enters all the valid details in the given textfields
      | name      | mobileNumber      | emailAddress      | password      | address      |
      | validName | validMobileNumber | validEmailAddress | validPassword | validAddress |
    And User clicks on submit button in textarea practice section

  Scenario: User fills the details in checkBox & radio button practice section
    When User selects female radio button in gender field
    And  User selects tuesday and friday checkbox in days field

  Scenario: User fills the details in dropdown practice section
    When User selects "Norway" in destination dropdown

  Scenario: User fills the details in checkBox & radio button practice xpath section
    When User selects two years of experience in test automation
    And User selects selenium webdriver and testng automation tools

  Scenario: User uploads a file in file input practice section
    When User browses and uploads valid file in file input section
      | image          |
      | smileImage.gif |

