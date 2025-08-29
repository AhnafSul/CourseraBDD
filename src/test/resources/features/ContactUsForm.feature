Feature: Validate Coursera University Contact Form

  Scenario: Submit the contact form with an invalid email and capture the error message
    Given I am on the Coursera home page
    When I click on "For University"
    And I click on "Contact Us"
    And I fill in the contact form with the following details
    And I submit the form
    Then I should see an error message for the email field
    And I capture and display the error message
