package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(xpath= "//a[@class='active-tab customers-tab']")
    WebElement customers;

    @FindBy(xpath= "//a[normalize-space()='Add Customer']")
    WebElement addCustomer;

    @FindBy(xpath= "//a[normalize-space()='View Customers']")
    WebElement viewCustomers;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickCustomer()
    {
        customers.click();
    }

    public void clickAddCustomer()
    {
        addCustomer.click();
    }

    public void clickViewCustomers()
    {
        viewCustomers.click();
    }
}
