package webDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverBase {
    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/hrishikeshgawde/Desktop/Airbus/src/main/java/webDrivers/data.properties");
        prop.load(fis);
        String browserName =prop.getProperty("browser");
        if(browserName.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/Users/hrishikeshgawde/Desktop/Selenium/chromedriver");
            driver= new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {

        }else if (browserName.equals("IE"))
        {

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}
