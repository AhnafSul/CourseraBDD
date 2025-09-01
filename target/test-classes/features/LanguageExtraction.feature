@skip
Feature: language and level extraction
	Scenario: extracting the language and levels from web development courses
		Given user is in the homepage
		When user search click language learning
		Then extract and print the available languages and level
