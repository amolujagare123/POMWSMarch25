package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

    @FindBy(name = "name")
    WebElement txtMovieName;

    @FindBy(name="submit")
    WebElement btnSubmit;

    public ForgotPassword(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void setTxtMovieName(String movie)
    {
        txtMovieName.sendKeys(movie);
    }

    public void clickSubmit()
    {
        btnSubmit.click();
    }
}
