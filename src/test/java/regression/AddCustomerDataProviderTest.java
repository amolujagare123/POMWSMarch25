package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddCustomer;
import pages.Login;
import pages.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class AddCustomerDataProviderTest {
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

    @Test (dataProvider = "getData")
    public void addCustomerTest(String name,String address,String contact1,String contact2)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Menu menu = new Menu(driver);
      //  menu.clickCustomer();
        menu.clickAddCustomer();

        AddCustomer addCustomer = new AddCustomer(driver);
        addCustomer.setName(name);
        addCustomer.setAddress(address);
        addCustomer.setContact1(contact1);
        addCustomer.setContact2(contact2);
        addCustomer.clickSubmit();
    }

    @DataProvider
        // (name = "myData")
    Object[][] getData() throws IOException {

        // 1. read the file
        FileInputStream fileInputStream = new FileInputStream("Data/data2.xlsx");

        // 2. create the object for workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 3. get the sheet
        XSSFSheet sheet = workbook.getSheet("Add Customer");

        // 4. count the number of active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

        // 5. count columns
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

           /* data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
            data[i][2] = row.getCell(2).toString();
            data[i][3] = row.getCell(3).toString();*/

            for(int j=0;j<colCount;j++) {

                XSSFCell cell = row.getCell(j);

                if(cell==null)
                    data[i][j] = "";
                else {
                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.toString();
                }
            }
        }

        /*data[0][0] = "admin";
        data[0][1] = "admin";

        data[1][0] = "invalid-1";
        data[1][1] = "invalid-1";

        data[2][0] = "invalid-2";
        data[2][1] = "invalid-2";

        data[3][0] = "invalid-3";
        data[3][1] = "invalid-3";*/

        return data;

    }
}
