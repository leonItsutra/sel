package daraz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
    private static  WebDriver driver;
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String DEFAULT_BROWSER_DRIVER_LOCATION = "C:\\ChromeDriver\\chromedriver.exe";
    private static final String DEFAULT_BROWSER_ENGINE = "webdriver.chrome.driver";

    public static WebDriver getDriver(){
        System.setProperty(DEFAULT_BROWSER_ENGINE, DEFAULT_BROWSER_DRIVER_LOCATION);
        driver = new ChromeDriver();
        return driver;
    }
}
