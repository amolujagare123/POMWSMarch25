package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddCustomer;
import pages.Login;
import pages.Menu;

import java.time.Duration;

public class AddCustomerTest {
    WebDriver driver;

    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");
        Login login = new Login(driver);

        login.setTxtUser("admin");
        login.setTxtPassword("admin");
        login.clickBtnLogin();
    }

    @Test
    public void addCustomerTest()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Menu menu = new Menu(driver);
      //  menu.clickCustomer();
        menu.clickAddCustomer();

        AddCustomer addCustomer = new AddCustomer(driver);
        addCustomer.setName("Sneha");
        addCustomer.setAddress("xyz");
        addCustomer.setContact1("78787");
        addCustomer.setContact2("78787");
        addCustomer.clickSubmit();
    }
}
