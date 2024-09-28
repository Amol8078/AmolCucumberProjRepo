package com.titan.stepDefinition;


import com.titan.contextManager.ContextText;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    ContextText contextText;

    public Hooks(ContextText contextText) {

        this.contextText = contextText;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("BEFORE : THREAD ID : " +Thread.currentThread().getId()+","+"SCENARIO NAME : " + scenario.getName());
    }
    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("AFTER : THREAD ID : " +Thread.currentThread().getId()+","+"SCENARIO NAME : " + scenario.getName());
        contextText.getDriverManager().shutDownDriver();
    }
    @AfterStep
    public void captureScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) contextText.getDriverManager().getDriverForLaunch()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

    }

}
