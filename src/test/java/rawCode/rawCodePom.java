package rawCode;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AirbusCareerHomePage;
import pageObjects.SearchPosition;

public class rawCodePom {
    public rawCodePom() {
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/hrishikeshgawde/Desktop/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.airbus.com/en/careers");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        AirbusCareerHomePage rd1 = new AirbusCareerHomePage(driver);
        SearchPosition rd2 = new SearchPosition(driver);
        rd1.OpenWorkdayPage().click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = (String)it.next();
        String childId = (String)it.next();
        driver.switchTo().window(childId);
        rd2.LocationButton().click();
        rd2.SearchBoxText().sendKeys(new CharSequence[]{"Uni"});
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        Iterator var8;
        WebElement jobNameOptions;
        if (!rd2.getCountryDynamicOption().isEmpty()) {
            var8 = rd2.getCountryDynamicOption().iterator();

            while(var8.hasNext()) {
                jobNameOptions = (WebElement)var8.next();
                if (jobNameOptions.getText().equalsIgnoreCase("United Kingdom")) {
                    jobNameOptions.click();
                    break;
                }
            }
        }

        rd2.locationErase().click();
        rd2.SearchBoxText().sendKeys(new CharSequence[]{"port"});
        Thread.sleep(1000L);
        if (!rd2.getCountryDynamicOption().isEmpty()) {
            var8 = rd2.getCountryDynamicOption().iterator();

            while(var8.hasNext()) {
                jobNameOptions = (WebElement)var8.next();
                if (jobNameOptions.getText().equalsIgnoreCase("Portsmouth")) {
                    jobNameOptions.click();
                    break;
                }
            }
        }

        rd2.viewJobButton().click();
        rd2.SearchBox().sendKeys(new CharSequence[]{"Test Engineer"});
        rd2.searchButton().click();
        Thread.sleep(3000L);
        var8 = rd2.allJobsSearch().iterator();

        while(var8.hasNext()) {
            jobNameOptions = (WebElement)var8.next();
            System.out.println("Job names areeeeee " + jobNameOptions.getText());
            if ("Software / Hardware Test and Integration Engineer".equalsIgnoreCase(jobNameOptions.getText())) {
                System.out.println(" Name found..........");
                jobNameOptions.click();
                break;
            }
        }

    }
}
