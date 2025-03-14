package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

    @FindBy(xpath= "//input[@id='name']")
    WebElement name;

    @FindBy(xpath= "//textarea")
    WebElement address;

    @FindBy(xpath= "//input[@id='buyingrate']")
    WebElement contact1;

    @FindBy(xpath= "//input[@name='contact2']")
    WebElement contact2;

    public AddCustomer(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void setName(String cName)
    {
        name.sendKeys(cName);
    }

    public void setAddress(String cAddress)
    {
        address.sendKeys(cAddress);
    }

    public void setContact1(String con1)
    {
        contact1.sendKeys(con1);
    }

    public void setContact2(String con2)
    {
        contact2.sendKeys(con2);

    }

    @FindBy(xpath= "//input[@name='Submit']")
    WebElement submit;

    public void clickSubmit()
    {
        submit.click();
    }
}
