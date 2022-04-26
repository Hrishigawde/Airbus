package TestCases;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AirbusCareerHomePage;
import pageObjects.PopUp;
import pageObjects.SearchPosition;
import webDrivers.DriverBase;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Test

public class AirbusJobSearch extends DriverBase {

    WebDriver stepDefDriver;

    public void driverNavigation() throws IOException {
        stepDefDriver = initializeDriver();
        stepDefDriver.get("https://www.airbus.com/en/careers");
    }


    @Given("User is on landing page follow the link to the Workday Jobs List")
    public void userIsOnLandingPageFollowTheLinkToTheWorkdayJobsList() {
       AirbusCareerHomePage rd1 = new AirbusCareerHomePage(stepDefDriver);
       rd1.OpenWorkdayPage().click();
    }

    @When("Using the filters user should be able to locate the role and apply")
    public void usingTheFiltersUserShouldBeAbleToLocateTheRole() throws InterruptedException {

       SearchPosition rd2 = new SearchPosition(stepDefDriver);
        Set<String> windows = stepDefDriver.getWindowHandles();  // parent id -> child id
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        stepDefDriver.switchTo().window(childId);

        rd2.LocationButton().click();
        rd2.SearchBoxText().sendKeys("Uni");
        stepDefDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (!rd2.getCountryDynamicOption().isEmpty())
            for (WebElement option : rd2.getCountryDynamicOption()) {
                if (option.getText().equalsIgnoreCase("United Kingdom")) {
                    option.click();
                    break;
                }
            }

        rd2.locationErase().click();
        rd2.SearchBoxText().sendKeys("port");
        Thread.sleep(1000);

        if (!rd2.getCountryDynamicOption().isEmpty())
            for (WebElement option : rd2.getCountryDynamicOption())
                if (option.getText().equalsIgnoreCase("Portsmouth")) {
                    option.click();
                    break;
                }

        rd2.viewJobButton().click();
        rd2.SearchBox().sendKeys("Test Engineer");
        rd2.searchButton().click();

        Thread.sleep(5000);

        for (WebElement jobNameOptions : rd2.allJobsSearch()) {
            System.out.println("Job names are "+ jobNameOptions.getText());
            if("Software / Hardware Test and Integration Engineer".equalsIgnoreCase(jobNameOptions.getText())){

                jobNameOptions.click();
                break;
            }

        }

        rd2.clickApply().click();
    }

    @AfterTest
    @And("detect that the pop up is present on the screen")
    public void checkPopupDisplayed() throws InterruptedException {

        PopUp rd3 =new PopUp(stepDefDriver);
        Assert.assertEquals(rd3.popUpDisplay().getText(),"Start Your Application");
        System.out.println(rd3.popUpDisplay().getText());


    }
}


