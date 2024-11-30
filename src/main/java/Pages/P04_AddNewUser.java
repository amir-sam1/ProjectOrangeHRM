package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_AddNewUser {
    SHAFT.GUI.WebDriver driver;

    public P04_AddNewUser(SHAFT.GUI.WebDriver driver){this.driver = driver;}




    //locators
    By userRoleDropDown = By.xpath("//label[contains(.,'User Role')]/../following-sibling::div");
    By selectUserRole = By.xpath("//div[@class=\"oxd-select-option\"][contains(.,'Admin')]");
    By employeeNameInput = By.xpath("(//label[contains(.,'Employee Name')]//following::input)[1]");
    By employeeNameEle = By.xpath("//p[@class=\"oxd-userdropdown-name\"]");
    By selectEmployee = By.xpath("(//div[@role=\"option\"])[1]");
    By statusDropDown = By.xpath("//label[contains(.,'Status')]/../following-sibling::div");
    By selectStatus = By.xpath("//div[@class=\"oxd-select-option\"][contains(.,'Enabled')]");
    By userNameInput = By.xpath("(//label[contains(.,'Username')]//following::input)[1]");
    By passwordInput = By.xpath("(//label[contains(.,'Password')]//following::input)[1]");
    By confirmPassInput = By.xpath("(//label[contains(.,'Confirm Password')]//following::input)[1]");
    By saveBtn = By.xpath("//button[@type=\"submit\"]");


    public P03_AdminPage fillForm(String newName , String pass){
        driver.element().click(userRoleDropDown).
                and().click(selectUserRole).
                and().click(statusDropDown).
                and().click(selectStatus).
                and().type(passwordInput,pass);
                driver.element().type(employeeNameInput,getUserName());

        /*WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(5));
        wait.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmployee));*/

        WebDriverWait wait1 = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait1.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(selectEmployee));
        driver.browser().captureScreenshot();
        driver.element().click(selectEmployee).
                and().type(userNameInput,newName).
                and().type(confirmPassInput,pass).
                and().click(saveBtn);
        return new P03_AdminPage(driver);
    }


    public String getUserName(){
         return driver.element().getText(employeeNameEle);

    }








}
