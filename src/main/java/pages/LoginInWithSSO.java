package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginInWithSSO {
    @FindBy(xpath = "//a[text()= 'Log in with SSO']")
    public WebElement loginButton;

    public void click(){
        loginButton.click();
    }

}
