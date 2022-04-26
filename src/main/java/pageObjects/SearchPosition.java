package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPosition {

    WebDriver driver;

    public SearchPosition(WebDriver driver){
        this.driver = driver;
    }

    By searchOptionLocationButton = By.xpath("//button[@data-automation-id='distanceLocation']");
    By dynamicSearchBoxText = By.xpath("//input[@class='css-1fvl6vb']");
    By locationSearchBoxOptions = By.xpath("//ul[@class='css-671ba7'] /li");
    By locationSearchBoxTextErase = By.xpath("//button[@class='css-126x3m4']//span[@class='css-9qs7ma']");
    By searchViewJobsButton = By.xpath("//button[@class='css-1yi7fg2']");
    By searchBoxSelection = By.xpath("//input[@class='css-19zlyzx']");
    By mainSearchButton = By.xpath("//button[@type='submit']");
    By allJobSearchOption = By.xpath("(//ul[@role='list'])  /li/div/div/div/h3/a");
    By jobSelection = By.xpath("//div[@class='css-b3pn3b'] ");
    By applyjob = By.xpath("//a[@data-automation-id='adventureButton']");


    public WebElement LocationButton(){
        return driver.findElement(searchOptionLocationButton);
    }

    public WebElement SearchBoxText(){
        return   driver.findElement(dynamicSearchBoxText);
    }

    public List<WebElement>  getCountryDynamicOption (){
        List<WebElement> country = driver.findElements(locationSearchBoxOptions);
        return country;
    }

    public WebElement locationErase(){
        return driver.findElement(locationSearchBoxTextErase);
    }

    public WebElement viewJobButton(){
        return driver.findElement(searchViewJobsButton);
    }

    public WebElement SearchBox(){
        return driver.findElement(searchBoxSelection);
    }

    public WebElement searchButton(){
        return driver.findElement(mainSearchButton);
    }

    public  List<WebElement> allJobsSearch(){
        List<WebElement> allJobs = driver.findElements(allJobSearchOption);
        return allJobs;
    }

    public WebElement selectJob (){
        return driver.findElement(jobSelection);
    }
    public WebElement clickApply (){
        return driver.findElement(applyjob);
    }

}
