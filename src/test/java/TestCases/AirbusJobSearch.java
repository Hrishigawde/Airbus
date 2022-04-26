package TestCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
@RunWith(Cucumber.class)

public class AirbusJobSearch extends DriverBase {


   public WebDriver driver = initializeDriver();

    public AirbusJobSearch() throws IOException {
        driver.get("https://www.airbus.com/en/careers");
    }

    @Given("User is on landing page follow the link to the Workday Jobs List")
    public void userIsOnLandingPageFollowTheLinkToTheWorkdayJobsList() {
       AirbusCareerHomePage rd1 = new AirbusCareerHomePage(driver);
       rd1.OpenWorkdayPage().click();
    }

    @When("Using the filters user should be able to locate the role and apply")
    public void usingTheFiltersUserShouldBeAbleToLocateTheRole() throws InterruptedException {

       SearchPosition rd2 = new SearchPosition(driver);
        Set<String> windows = driver.getWindowHandles();  // parent id -> child id
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        rd2.LocationButton().click();
        rd2.SearchBoxText().sendKeys("Uni");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
            if("Software / Hardware Test and Integration Engineer".equalsIgnoreCase(jobNameOptions.getText())){
                    jobNameOptions.click();
                    break;
            }

        }

        rd2.clickApply().click();
    }

    @Then("detect that the pop up is present on the screen")
    public void checkPopupDisplayed() throws InterruptedException {
        //checking pop-up
        PopUp rd3 =new PopUp(driver);
        Assert.assertEquals(rd3.popUpDisplay().getText(),"Start Your Application");
        System.out.println(rd3.popUpDisplay().getText());

    }
}


