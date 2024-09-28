package com.titan.managers;


import com.titan.baseClass.BaseClass;
import com.titan.pageObjects.LoginPage.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageManager {

    private WebDriver driver;
    private LoginPage loginPage;
    private BaseClass baseClass;

    public PageManager(WebDriver driver) {
        this.driver = driver;

    }
    public BaseClass getBaseClass() {

        return (baseClass==null) ? baseClass=new BaseClass(driver):baseClass;
    }
    public LoginPage getLoginPage() {

        return (loginPage==null) ? loginPage=new LoginPage(driver):loginPage;
    }
}
