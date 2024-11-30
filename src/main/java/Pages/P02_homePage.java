package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_homePage {
    SHAFT.GUI.WebDriver driver;
    public P02_homePage(SHAFT.GUI.WebDriver driver) {this.driver=driver;}

    //Locators
    By adminTab = By.xpath("//a[@class=\"oxd-main-menu-item\"]//span[contains(.,'Admin')]");



    //Method
    public P03_AdminPage clickOnAdminTab(){
        driver.element().click(adminTab);
        return new P03_AdminPage(driver);
    }

}
