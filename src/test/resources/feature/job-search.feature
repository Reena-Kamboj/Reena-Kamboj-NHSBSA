Feature: NHS Jobs Search Functionality

  As a jobseeker on the NHS jobs website
  I want to search for jobs using my preferences
  So that I can view recently posted job results

  Background:
    Given I am on the NHS Jobs search page

    #Basic Search
  Scenario: Search with keyword only
    When I enter "Nurse" in job title
    And I click search
    Then I should see job results matching my search criteria

  Scenario: Search with location only
    When I enter "Leeds" in Location
    And I click search
    Then I should see job results matching my search criteria

  Scenario: Search jobs using valid keyword and location
    When I search for jobs with keyword "healthcare assistant" and location "London"
    And I click search
    Then I should see job results matching my search criteria

  #sorting
  Scenario: Sort job results by newest date posted
    When I search for jobs with keyword "Administrator" and location "Manchester"
    And I click search
    And I sort the search results by "DatePosted(newest)"
    Then The job results should be displayed in descending order of date posted

   #invalid search
  Scenario: Search jobs using invalid keyword and location
    When I search for jobs with keyword "xyzinvaildjob" and location "invalidlocation"
    And I click search
    Then I should see a location not found message

  #Empty Search
  Scenario: Search with empty keyword and location
    When I search for jobs with keyword "" and location ""
    And I click search
    Then I should see a list of job results(all jobs displayed)

  #individual filter search
  Scenario: Search using Distance filter with location
    When I enter "London" in Location
    And I select "+20 Miles" in distance
    And I click search
    Then I should see job results matching my search criteria

  Scenario: Search jobs using pay range and organisation type
    When I click more search options
    And I select "£30,000 to £40,000" in pay range
    And I select "NHS" in Organisation type
    And I click search
    Then I should see job results matching my search criteria

  Scenario: Search jobs using invalid job reference
    When I click more search options
    And I enter "12345" in job reference
    And I click search
    Then No job results found

  #combined search
  Scenario: Search jobs using combined filters
    When I enter "Nurse" in job title
    When I enter "London" in Location
    And I select "+5 Miles" in distance
    And I click more search options
    And I select "£40,000 to £50,000" in pay range
    And I select "NHS" in Organisation type
    And I click search
    Then I should see job results matching my search criteria

  Scenario: Search options
    When I click more search options
    Then advance filters should be displayed
    When I click Fewer search options
    Then advanced search filters should be hidden

