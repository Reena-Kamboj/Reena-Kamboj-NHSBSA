package stepdefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.JobSearchPage;
import utils.DriverSetup;

public class JobSearchSteps {
    WebDriver driver;
    JobSearchPage jobSearchPage;

    @Given("I am on the NHS Jobs search page")
    public void openSearch() {
        driver = DriverSetup.getDriver();
        driver.get("https://www.jobs.nhs.uk/candidate/search");
        jobSearchPage = new JobSearchPage(driver);
    }

    @When("I search for jobs with keyword {string} and location {string}")
    public void iSearchJobs(String keyword, String location) {
        jobSearchPage.seachJobs(keyword, location);

    }

    @Then("I should see a list of job results matching my search criteria")
    public void verifyResults() {
        Assert.assertTrue(jobSearchPage.allJobDisplayed(), "job results not displayed");

    }

    @And("I sort the search results by {string}")
    public void iSortTheSearchResultsBy(String options) {
        if (options.equalsIgnoreCase("Date Posted (newest)")) {
            jobSearchPage.sortByNewest();
        }
    }

    @Then("The job results should be displayed in descending order of date posted")
    public void sortedResults() {
        Assert.assertTrue(jobSearchPage.getResultsCount() > 0, "no job results for verify sorting");

    }

    @Then("I should see a location not found message")
    public void iShouldSeeALocationNotFoundMessage() {
        Assert.assertTrue(jobSearchPage.noResultFound(), "Location not found message not displayed");

    }

    @Then("I should see a list of job results\\(all jobs displayed)")
    public void iShouldSeeAListOfJobResultsAllJobsDisplayed() {
        Assert.assertTrue(jobSearchPage.allJobDisplayed(), "All job not displayed for empty search");

    }

    @When("I enter {string} in job title")
    public void enterJobTitle(String title) {
        jobSearchPage.enterJobTitle(title);
    }

    @When("I enter {string} in Location")
    public void enterLocation(String text) {
        jobSearchPage.enterLocation(text);
    }

    @And("I click search")
    public void iClickSearch() {
        jobSearchPage.clickSearch();
    }

    @And("I select {string} in distance")
    public void iSelectInDistance(String distance) {
        jobSearchPage.selectDistance(distance);
    }

    @And("I select {string} in pay range")
    public void iSelectInPayRange(String value) {
        jobSearchPage.payRange(value);
    }

    @And("I select {string} in Organisation type")
    public void iSelectInOrganisationType(String type) {
        jobSearchPage.selectType(type);
    }

    @When("I click more search options")
    public void iClickMoreSearchOptions() {
        jobSearchPage.clickMoreOptions();
    }

    @And("I enter {string} in job reference")
    public void iEnterInJobReference(String value) {
        jobSearchPage.jobReference(value);
    }

    @When("I click Fewer search options")
    public void iClickFewerSearchOptions() {
        jobSearchPage.clickFewerOptions();
    }

    @Then("No job results found")
    public void noJobResultsFound() {
        jobSearchPage.noResultsDisplayed();
    }

    @Then("I should see job results matching my search criteria")
    public void jobResult() {
        jobSearchPage.allJobDisplayed();
    }


    @Then("advance filters should be displayed")
    public void advanceFiltersShouldBeDisplayed() {
        jobSearchPage.resultsDisplayed();
    }

    @Then("advanced search filters should be hidden")
    public void advancedSearchFiltersShouldBeHidden() {
        jobSearchPage.noResultsDisplayed();
    }
}
