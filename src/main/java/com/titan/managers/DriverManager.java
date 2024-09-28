package com.titan.managers;


import com.titan.enumerator.SelectDriver;
import com.titan.enumerator.SelectEnv;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    private static SelectDriver selectDriver;
    private static SelectEnv selectEnv;

    public DriverManager() {
        selectDriver = ReaderManager.getInstance().getConfigReader().getDriver();
        selectEnv = ReaderManager.getInstance().getConfigReader().getEnv();

    }

    public WebDriver getDriverForLaunch() {
        if (driver == null) {
            driver = createDriverForLaunch();
        }
        return driver;
    }

    private WebDriver createDriverForLaunch() {
        switch (selectEnv) {
            case LOCAL:
                driver = createLocalDriverForLaunch();
                break;
            case REMOTE:
                driver = createRemoteDriverForLaunch();
                break;
        }
        return driver;

    }

    private WebDriver createLocalDriverForLaunch() {
        switch (selectDriver) {
            case CHROME:
                //    WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriverForLaunch() {

        throw new RuntimeException("remote env is not available");

    }

    public void shutDownDriver() {

        //driver.quit();
    }


}
