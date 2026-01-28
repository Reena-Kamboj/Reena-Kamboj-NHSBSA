Feature: NHS Jobs Search Functionality

  As a jobseeker on the NHS jobs website
  I want to search for jobs using my preferences
  So that I can view recently posted job results

  Background:
    Given I am on the NHS Jobs search page

  Scenario: Search jobs using valid keyword and location
    When I search for jobs with keyword "healthcare assistant" and location "London"
    Then I should see a list of job results matching my search criteria

  Scenario: Sort job results by newest date posted
    When I search for jobs with keyword "Administrator" and location "Manchester"
    And I sort the search results by "DatePosted(newest)"
    Then The job results should be displayed in descending order of date posted

  Scenario: Search jobs using invalid keyword and location
    When I search for jobs with keyword "xyzinvaildjob" and location "invalidlocation"
    Then I should see a location not found message

  Scenario: Search with empty keyword and location
    When I search for jobs with keyword "" and location ""
    Then I should see a list of job results(all jobs displayed)