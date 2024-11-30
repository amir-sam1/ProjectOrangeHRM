package Pages;

import com.shaft.driver.SHAFT;
import lombok.NonNull;
import org.openqa.selenium.By;


public class P03_AdminPage {
    SHAFT.GUI.WebDriver driver;
    static int originalRecords, currentRecords, afterRecords;

    public P03_AdminPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}

    //locators
    By numberOfRecords = By.xpath("//span[contains(@class,'oxd-text')][contains(.,'Records')]");
    By addBtn = By.xpath("//button[@type=\"button\"][contains(.,'Add')]");
    By messageSuccess = By.xpath("//p[contains(@class,'oxd-text oxd-text-')][contains(.,'Successfully Saved')]");
    By userNameInput = By.xpath("(//label[contains(.,'Username')]//following::input)[1]");
    By employeeNameEle = By.xpath("//p[@class=\"oxd-userdropdown-name\"]");
    By searchBtn = By.xpath("//button[@type=\"submit\"]");
    By deleteBtn = By.xpath("//i[@class=\"oxd-icon bi-trash\"]");
    By yesDeleteBtn = By.xpath("//button[contains(.,' Yes, Delete ')]");
    By restBtn = By.xpath("//button[@type=\"button\" and contains(.,' Reset ')]");



    public int getNumberOfRecords(){
        int numOfRecord = Integer.parseInt(driver.element().getText(numberOfRecords).replaceAll("[^0-9]", ""));
        return numOfRecord;


    }

    public P03_AdminPage getOriginalRecords(){
        originalRecords = getNumberOfRecords();
        return this;
    }

    public P03_AdminPage getCurrentRecords(){
        currentRecords = getNumberOfRecords();
        return this;
    }

    public P03_AdminPage getAfterRecords(){
        afterRecords = getNumberOfRecords();

        return this;

    }




    public P04_AddNewUser clickOnAdd(){
        driver.element().click(addBtn);
        return new P04_AddNewUser(driver);

    }

    public P03_AdminPage formSubmittedSuccessfully(){
        driver.element().assertThat(messageSuccess).exists().perform();
        return this;
    }

    public P03_AdminPage verifyNumIncrease(){
        SHAFT.Validations.verifyThat().object(currentRecords).isEqualTo(originalRecords+1);
        return this;

    }


   /* public P04_AddNewUser searchNewUser() throws InterruptedException {
        wait(5000);
        driver.element().type(searchNewUser().userNameInput, searchNewUser().getUserName());
        return new P04_AddNewUser(driver);


    }*/
    public P03_AdminPage searchNewUser(String newUser){
        driver.element().type(userNameInput, newUser).
                and().click(searchBtn).click(deleteBtn).click(yesDeleteBtn).
                and().click(restBtn);

        return this;


    }

    public void verifyNumDecrease(){
        SHAFT.Validations.verifyThat().object(afterRecords).isEqualTo(originalRecords-1);

    }













}
