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
    public void openSearch(){
        driver= DriverSetup.getWebdriver();
        driver.get("https://www.jobs.nhs.uk/candidate/search");
        jobSearchPage=new JobSearchPage(driver);
    }

    @When("I search for jobs with keyword {string} and location {string}")
    public void iSearchJobs(String keyword, String location) {
        jobSearchPage.seachJobs(keyword,location);
    }

    @Then("I should see a list of job results matching my search criteria")
    public void verifyResults() {
        Assert.assertTrue(jobSearchPage.allJobDisplayed(),"job results not displayed");
        DriverSetup.quitDriver();
    }

    @And("I sort the search results by {string}")
    public void iSortTheSearchResultsBy(String options) {
        if(options.equalsIgnoreCase("Date Posted (newest)")){
            jobSearchPage.sortByNewest();
        }
    }

    @Then("The job results should be displayed in descending order of date posted")
    public void sortedResults() {
        Assert.assertTrue(jobSearchPage.getResultsCount()>0,"no job results for verify sorting");
        DriverSetup.quitDriver();
    }

    @Then("I should see a location not found message")
    public void iShouldSeeALocationNotFoundMessage() {
        Assert.assertTrue(jobSearchPage.noResultFound(),"Location not found message not displayed");
        DriverSetup.quitDriver();
    }

    @Then("I should see a list of job results\\(all jobs displayed)")
    public void iShouldSeeAListOfJobResultsAllJobsDisplayed() {
        Assert.assertTrue(jobSearchPage.allJobDisplayed(),"All job not displayed for empty search");
        DriverSetup.quitDriver();
    }

}
