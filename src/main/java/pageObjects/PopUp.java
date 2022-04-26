package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUp {
    WebDriver driver;

    public PopUp(WebDriver driver){
        this.driver = driver;
    }
     By popup = By.cssSelector(".css-124gh4t");

    public WebElement popUpDisplay(){
        return driver.findElement(popup);

    }
}
