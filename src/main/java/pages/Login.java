package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
  /*  WebDriver driver;
    WebElement element = driver.findElement(By.id(""));*/

    @FindBy(id="login-username")
    WebElement txtUser;

    @FindBy(id="login-password")
    WebElement txtPassword;

    @FindBy(name="submit")
    WebElement btnLogin;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtUser(String user)
    {
        txtUser.sendKeys(user);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickBtnLogin()
    {
        btnLogin.click();
    }

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPassword;

    public void clickForgotPassword()
    {
        forgotPassword.click();
    }
}
