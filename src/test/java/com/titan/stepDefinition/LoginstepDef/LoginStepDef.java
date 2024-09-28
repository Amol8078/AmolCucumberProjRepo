package com.titan.stepDefinition.LoginstepDef;

import com.titan.contextManager.ContextText;
import com.titan.pageObjects.LoginPage.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginStepDef {
    ContextText contextText;
    LoginPage loginPage;

    public LoginStepDef(ContextText contextText) {
        this.contextText = contextText;
        loginPage = contextText.getPageManager().getLoginPage();
    }



    @Given("User is on home page")
    public void user_is_on_home_page() {
        loginPage.userLaunchAndValidateHomePage("OrangeHRM");
    }

    @When("User enter Username and Password")
    public void user_enter_username_and_password() {

        loginPage.userEnterUserNameAndPassword();
    }

    @And("User click on login button")
    public void user_click_on_login_button() {

        loginPage.userClickOnLoginBtn();
    }

    @And("User enter and validate the otp")
    public void user_enter_and_validate_the_otp(DataTable dataTable) {
        List<String> name = dataTable.asList(String.class);
        for (String otpValue : name) {
            loginPage.userEnterAndValidateOtp(otpValue);
        }

    }

    @Then("User should able to login")
    public void user_should_able_to_login() {

        loginPage.validateSuccessfulLogin("OrangeHRM");
    }
}
