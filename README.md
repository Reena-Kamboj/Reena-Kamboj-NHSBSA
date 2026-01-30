# Reena-Kamboj-NHSBSA

## Project Overview
This project automates the "NHS Jobs Search Functionality"
It verifies that jobseeker can:
- Search using Keyword only
- Search using location only
- Search for jobs using keyword and location
- Sort results by newest date
- Handle invalid location/keywords
- Handle empty search

Filter Scenarios:
- Search using distance filter(with valid location)
- Search using job reference filter
- Search using pay range filter
- Search using combined filters(keyword,location,distance,payrange,organisation type)


Tests are written in BDD format using Cucumber, with Java 21, Selenium,and Testng,following Page Object Model

## Tech Stack
- Java 21
- Selenium 
- Cucumber
- TestNG
- Maven

## Browsers Supported
- Chrome
- Firefox

## How to Run Tests
- From IDE Right click TestNGRunner.java ->Run as TestNG
- From Command Line(Maven)
  # uses mvn clean test

## Reports: target/cucumber-report.html