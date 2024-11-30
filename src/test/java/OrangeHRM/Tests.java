package OrangeHRM;

import Pages.P01_LoginPage;
import Pages.P02_homePage;
import Pages.P03_AdminPage;
import Pages.P04_AddNewUser;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {

    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testDate;

    //Test Methods
    @Test
    public void login() throws InterruptedException {
        new P01_LoginPage(driver).loginSteps(testDate.getTestData("userName"),testDate.getTestData("password")).
                clickOnAdminTab().
                getOriginalRecords().
                clickOnAdd().
                fillForm(testDate.getTestData("newUser"),testDate.getTestData("Pass")).
                formSubmittedSuccessfully().
                getCurrentRecords().
                verifyNumIncrease().
                getOriginalRecords().
                searchNewUser(testDate.getTestData("newUser")).
                getAfterRecords().
                verifyNumDecrease();






        Thread.sleep(5000);


    }





    //Before Method
    @BeforeMethod
    public void setUp(){
        driver = new SHAFT.GUI.WebDriver();
        testDate = new SHAFT.TestData.JSON("orangeTestData.json");
        driver.browser().navigateToURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    //After Method
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }






}
