package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AirbusCareerHomePage {
    WebDriver driver;

    public AirbusCareerHomePage(WebDriver driver){
        this.driver =driver;
    }

    By openPositions = By.xpath("//a[@href='https://ag.wd3.myworkdayjobs.com/en-US/Airbus']");

    public WebElement OpenWorkdayPage(){
        return driver.findElement(openPositions);
    }
}
