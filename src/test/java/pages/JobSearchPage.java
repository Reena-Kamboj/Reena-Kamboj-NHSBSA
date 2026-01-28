package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JobSearchPage {
    WebDriver driver;

    public JobSearchPage(WebDriver driver){
        this.driver=driver;
    }

   private By keywordInput=By.id("keyword");
   private By locationInput=By.id("location");
   private By searchButton=By.id("search");
   private By sortDropDown=By.id("sort");
   private By searchResults=By.id("first-result-title");

   public void seachJobs(String keyword,String location){
       driver.findElement(keywordInput).clear();
       driver.findElement(keywordInput).sendKeys(keyword);

       driver.findElement(locationInput).clear();
       driver.findElement(locationInput).sendKeys(location);

       driver.findElement(searchButton).click();
   }

   public void sortByNewest(){
       WebElement dropdown=driver.findElement(sortDropDown);
       Select select=new Select(dropdown);
       select.selectByVisibleText("Date Posted (newest)");
   }

   public int getResultsCount(){
       List<WebElement>  results=driver.findElements(searchResults);
       return results.size();
   }

   public boolean noResultFound(){
     return driver.getPageSource().contains("Location not found")
             ||driver.getTitle().contains("Location not found");
   }
   public boolean allJobDisplayed(){
       return getResultsCount()>0;
   }

}
