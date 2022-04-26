package rawCode;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_META;

public class AirBus {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        System.setProperty("webdriver.chrome.driver", "/Users/hrishikeshgawde/Desktop/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='https://ag.wd3.myworkdayjobs.com/en-US/Airbus']")).click();
        Set<String> windows = driver.getWindowHandles();  // parent id -> child id
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.findElement(By.xpath("(//span[@class='css-p4a0l1'])[2]")).click();





        driver.findElement(By.xpath("(//input[@class='css-m8i1zd'])[1]")).sendKeys("hrishi.gawde@gmail.com");
        driver.findElement(By.xpath("(//input[@class='css-m8i1zd'])[2]")).sendKeys("Dv@2119tx");
        Thread.sleep(4000);
        //WebDriverWait wait = new WebDriverWait(driver,10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Sign In']")));
        driver.findElement(By.xpath("//div[@aria-label='Sign In']")).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@data-automation-id='distanceLocation']")).click();
        driver.findElement(By.xpath("//input[@class='css-1fvl6vb']")).sendKeys("unit");

        List<WebElement> optionsCountry = driver.findElements(By.xpath("//ul[@class='css-671ba7'] /li"));
        Thread.sleep(2000);

        for (WebElement option : optionsCountry) {
            if(option.getText().equalsIgnoreCase("United Kingdom")){
                option.click(); break;
            }
        }

        driver.findElement(By.xpath("//button[@class='css-126x3m4']//span[@class='css-9qs7ma']")).click();
        driver.findElement(By.xpath("//input[@class='css-1fvl6vb']")).sendKeys("port");

        List<WebElement> optionsLocation = driver.findElements(By.xpath("//ul[@class='css-671ba7'] /li"));

        for (WebElement option : optionsLocation) {
            if(option.getText().equalsIgnoreCase("Portsmouth")){
                option.click(); break;
            }
        }
        driver.findElement(By.xpath("//button[@class='css-1yi7fg2']")).click();

        driver.findElement(By.xpath("//input[@class='css-19zlyzx']")).sendKeys("Test Engineer");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href='/en-US/Airbus/job/Portsmouth/Software-Systems-Integration-and-Test-Engineer_JR10073633']")).click();
        //driver.findElement(By.xpath("//a[@class='css-g71a1a']")).click();
        driver.findElement(By.xpath("//a[@class='css-g71a1a']")).click();


        driver.findElement(By.xpath("//a[@class='css-pc7vm7']")).click();

        Thread.sleep(5000);


        driver.findElement(By.xpath("//div[@class='css-1ikudie']")).click();

        robot.setAutoDelay(1000);

        StringSelection stringSelection = new StringSelection("/Users/hrishikeshgawde/Documents/CV Updated Jan 22/Hrishikesh Gawde_2022.pdf");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);


        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_TAB);        // found out that java having bugs while handling mac command key so this is the way mentioned in stackoverflow
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_META);

        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

//Select file and upload command

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".css-up0scl")).click();
        driver.findElement(By.cssSelector("button[aria-label='How Did You Hear About Us? select one required']")).sendKeys("link");
        Thread.sleep(2000);


        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type='text'][data-automation-id='addressSection_addressLine1']")).sendKeys("31 Hammerley Road");
        driver.findElement(By.cssSelector("input[data-automation-id='addressSection_postalCode']")).sendKeys("SO50 7HQ");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@data-automation-id='bottom-navigation-next-button']")).click();
        driver.findElement(By.xpath("//button[@data-automation-id='bottom-navigation-next-button']")).click();
        driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected();
       Thread.sleep(10000);
       //driver.quit();
    }
}

