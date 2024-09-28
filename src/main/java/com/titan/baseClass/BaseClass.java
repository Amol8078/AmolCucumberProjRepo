package com.titan.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseClass {

    static WebDriver driver;

    public BaseClass(WebDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(driver, null);

    }
     Logger logger = LoggerFactory.getLogger(BaseClass.class);

      public static void implicitWait(WebDriver driver,int waitInSec){
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSec));
      }
    public static void waitForVisibilityOfElement(WebElement element, WebDriver driver, int waitInSec){
          new WebDriverWait(driver,Duration.ofSeconds(waitInSec)).until(ExpectedConditions.visibilityOf(element));
    }
    public static void sendValueInTxtBox(WebElement element,String txtValue){

          element.sendKeys(txtValue);
    }
      public static void clickOnElement(WebElement element){

          element.click();

      }

}
