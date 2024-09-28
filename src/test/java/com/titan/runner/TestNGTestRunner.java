package com.titan.runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/titan/stepDefinition"},
        tags = "@login",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true,
        dryRun =true
)




public class TestNGTestRunner extends AbstractTestNGCucumberTests{


}
