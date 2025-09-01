Feature: Validate Coursera University Contact Form

  Scenario: Submit the contact form with an invalid email and capture the error message
    Given I am on the Coursera home page
    When I navigate to the university contact form and click on contact us button
    And I fill in the contact form with the Excel details
    And I submit the form
    Then I should see an error message for the email field
