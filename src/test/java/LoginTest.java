import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest {


    @Test
    public void loginTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");
        Login login = new Login(driver);

        login.setTxtUser("admin");
        login.setTxtPassword("admin");
        login.clickBtnLogin();
        Assert.assertEquals(driver.getTitle(),"POSNIC - Dasboard");
    }
}
