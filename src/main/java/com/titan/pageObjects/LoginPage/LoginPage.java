package com.titan.pageObjects.LoginPage;

import com.titan.baseClass.BaseClass;
import com.titan.managers.ReaderManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameTxtBox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordTxtBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//input[@id='otp']")
    private WebElement otpTxtBox;

    @FindBy(xpath = "//span[normalize-space()='Validate']")
    private WebElement validateOtpBtn;


    public void userLaunchAndValidateHomePage(String expectedPageTile) {
        LoginPage.driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
        LoginPage.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        String actualPageTitle = LoginPage.driver.getTitle();
        Assert.assertEquals("validate user is on home page ", expectedPageTile, actualPageTitle);

    }

    public void userEnterUserNameAndPassword() {
        BaseClass.waitForVisibilityOfElement(userNameTxtBox, LoginPage.driver, 20);
        BaseClass.sendValueInTxtBox(userNameTxtBox, ReaderManager.getInstance().getConfigReader().getUserName());

        BaseClass.waitForVisibilityOfElement(userPasswordTxtBox, LoginPage.driver, 20);
        BaseClass.sendValueInTxtBox(userPasswordTxtBox, ReaderManager.getInstance().getConfigReader().getPassword());

    }

    public void userClickOnLoginBtn() {
        BaseClass.waitForVisibilityOfElement(loginBtn, LoginPage.driver, 20);
        BaseClass.clickOnElement(loginBtn);
    }

    public void userEnterAndValidateOtp(String otpValue) {
        BaseClass.waitForVisibilityOfElement(otpTxtBox, LoginPage.driver, 20);
        BaseClass.sendValueInTxtBox(otpTxtBox, otpValue);
        BaseClass.waitForVisibilityOfElement(validateOtpBtn, LoginPage.driver, 20);
        BaseClass.clickOnElement(validateOtpBtn);
    }
    public void validateSuccessfulLogin(String pageContent) {
        Assert.assertTrue("validate user successfully logged in ", LoginPage.driver.getPageSource().contains(pageContent));

    }


}
