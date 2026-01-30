package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JobSearchPage {
    WebDriver driver;

    public JobSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private By keywordInput = By.id("keyword");
    private By locationInput = By.id("location");
    private By searchButton = By.id("search");
    private By sortDropDown = By.id("sort");
    private By searchResults = By.id("first-result-title");
    private By moreOptions = By.linkText("More search options");
    private By fewerOptions = By.linkText("Fewer search options");
    private By dis = By.id("distance");
    private By payRange = By.id("payRange");
    private By jobReference = By.id("jobReference");
    private By organisationType = By.id("employer");


    public void enterJobTitle(String title) {
        driver.findElement(keywordInput).clear();
        driver.findElement(keywordInput).sendKeys(title);
    }

    public void enterLocation(String location) {
        driver.findElement(locationInput).clear();
        driver.findElement(locationInput).sendKeys(location);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public void seachJobs(String keyword, String location) {
        driver.findElement(keywordInput).clear();
        driver.findElement(keywordInput).sendKeys(keyword);

        driver.findElement(locationInput).clear();
        driver.findElement(locationInput).sendKeys(location);

        // driver.findElement(searchButton).click();
    }

    public void clickMoreOptions() {
        driver.findElement(moreOptions).click();
    }

    public void clickFewerOptions() {
        driver.findElement(fewerOptions).click();
    }

    public void sortByNewest() {
        WebElement dropdown = driver.findElement(sortDropDown);
        Select select = new Select(dropdown);
        select.selectByVisibleText("Date Posted (newest)");
    }

    public int getResultsCount() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size();
    }

    public boolean noResultFound() {
        return driver.getPageSource().contains("Location not found")
                || driver.getTitle().contains("Location not found");
    }

    public boolean allJobDisplayed() {
        return getResultsCount() > 0;
    }

    public void selectDistance(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement d = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dis)));
        Select select = new Select(d);
        select.selectByVisibleText(value);
    }

    public void payRange(String value) {
        Select select = new Select(driver.findElement(payRange));
        select.selectByVisibleText(value);
    }

    public void selectType(String text) {
        driver.findElement(organisationType).sendKeys(text);
    }

    public void jobReference(String text) {
        driver.findElement(jobReference).sendKeys(text);
    }

    public boolean resultsDisplayed() {
        return driver.getPageSource().contains("jobs found");
    }

    public boolean noResultsDisplayed() {
        return driver.getPageSource().contains("No jobs found");
    }
}



