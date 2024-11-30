package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_LoginPage {

    SHAFT.GUI.WebDriver driver;

    //Constructor
    public P01_LoginPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}

    //locators
    By userNameInput = By.cssSelector("input[name=\"username\"]");
    By passwordInput = By.cssSelector("input[name=\"password\"]");
    By loginBtn = By.xpath("//button[@type=\"submit\"]");

    //Method
    public P02_homePage loginSteps(String name , String password){
        driver.element().type(userNameInput,name).
                and().type(passwordInput,password).
                and().click(loginBtn);
        return new P02_homePage(driver);


    }






}
