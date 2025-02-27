package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginToAccount extends CommonMethods{
    public WebDriver driver;
    ReadFromExcel re = new ReadFromExcel();
    public LoginToAccount(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //finding xpaths for login


    @FindBy(xpath = "//span[normalize-space()='My Account']") public WebElement selectMyAccount;
    @FindBy(xpath = "//a[normalize-space()='Login']") public WebElement login;
    @FindBy(xpath = "//h2[normalize-space()='New Customer']") public WebElement newCustomerdisplaying;
    @FindBy(xpath = "//a[normalize-space()='Continue']") public WebElement continueButton;





    public void verifySelectMyAccount() throws InterruptedException{
        //Select sc = new Select(selectMyAccount);
        //sc.selectByVisibleText("Login");
        selectMyAccount.click();
        login.click();
        Thread.sleep(3000);
    }

    public void clickContinueButton()throws InterruptedException{
        continueButton.click();
    }

    @FindBy(xpath = "//input[@id='input-email']") public WebElement emailField;
    @FindBy(xpath = "//input[@id='input-password']") public WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']") public WebElement loginButton;





    public void verifyLogin() throws InterruptedException, IOException {
        String path ="C:\\Users\\rumam\\IdeaProjects\\NewProject_Demo\\excelfileforlogin\\LOGIN.xlsx";
        ReadFromExcel rd = new ReadFromExcel();
        String  datasheet[][]= rd.readFromExcelSheet(path, 0);
        emailField.sendKeys(datasheet[0][0]);
        passwordField.sendKeys(datasheet[0][1]);
        loginButton.click();

    }

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") public WebElement errorMessage;

    public String verifyLoginErrorMessage(){
        return errorMessage.getText();
    }


}
