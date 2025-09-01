@skip
Feature: Coursera Course Search and Extraction
 
  Scenario: Extracting course details for beginners in web development
    Given the user is in home page
    When the user searches for "web development courses"
    And filters by Beginner level and English language
    Then the system should extract the course name,total hours,rating for the first two courses