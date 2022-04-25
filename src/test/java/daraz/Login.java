package daraz;

import daraz.base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class Login {
    private WebDriver driver = null;

    @BeforeTest
    public void preSetUp()  {
        driver = BaseDriver.getDriver();
        driver.get("https://stackoverflow.com/c/sutrabase/questions/ask");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }

    @Test
    public void login() throws InterruptedException {
        WebElement linkSSO =  driver.findElement(By.xpath("//a[text()= 'Log in with SSO']"));
        Assert.assertTrue(linkSSO.isDisplayed());
        linkSSO.click();
        driver.findElement(By.id("i0116")).sendKeys("leon@itsutra.com");
        driver.findElement(By.id("idSIButton9")).click();
        driver.findElement(By.id("i0118")).sendKeys("Nayasansar112");
        waitForInteractable("//*[@id = 'idSIButton9']");
        driver.findElement(By.id("idSIButton9")).click();
        waitForVisibilityExplicit("//*[@id = 'idSIButton9']");
        driver.findElement(By.id("idSIButton9")).click();
    }

    public void waitForVisibilityExplicit( String xpath){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void waitForInteractable(String xpath){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }



    @Test(dependsOnMethods = "login")
    public void setValues() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id = 'title' and @name = 'title']")).sendKeys("find element by name and id name both in selenium java");
        driver.findElement(By.xpath("//*[@class = 'fl-grow1 outline-none p12 pt6 w100 s-prose js-editor ProseMirror']")).sendKeys("find element by name and id name both in selenium java");
        driver.findElement(By.id("tageditor-replacing-tagnames--input")).sendKeys("selenium");
        waitForVisibilityExplicit("//span[text() = 'selenium']");
        driver.findElement(By.xpath("//span[text() = 'selenium']")).click();
        driver.findElement(By.id("tageditor-replacing-tagnames--input")).sendKeys("java");
        waitForVisibilityExplicit("//span[text() = 'java']");
        driver.findElement(By.xpath("//span[text() = 'java']")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
