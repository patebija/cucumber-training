package com.qascript.stepDefinitions;

import com.qascript.pageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.qascript.utils.BaseClass.*;

public class LoginStepDefs {

    @Before
    public void setup(){
        startDriver();
    }

    @After
    public void close(){
        closeDriver();
    }


    @Given("^User enters valid (.*) in EnterUsername field$")
    public void enterUsername(String username){
        LoginPage.enterEmail(username);

    }

    @And("^User enters valid (.*) in EnterPassword field$")
    public void enterPassword(String password){
        LoginPage.enterPassword(password);

    }

    @When("^User clicks on Login button$")
    public void clickLoginButton(){
        LoginPage.clickLogin();
    }

    @Then("^User is logged in successfully$")
    public void validateLogin(){
        LoginPage.validateSuccessfulLogin("Abi");
    }


    @Given("Launch Flipkart application")
    public void launchFlipkartApplication() {
        launchApplication();
    }

    @Given("^User enters invalid (.*) in EnterUsername field$")
    public void userEntersInvalidUsernameInEnterUsernameField(String username) {
        LoginPage.enterEmail(username);
    }

    @And("^User enters invalid (.*) in EnterPassword field$")
    public void userEntersInvalidPasswordInEnterPasswordField(String password) {
        LoginPage.enterPassword(password);
    }

    @Then("User cannot login into application")
    public void userCannotLoginIntoApplication() {
       LoginPage.validateUnsuccessfulLogin("Your username or password is incorrect");

    }

    @And("User is logged in")
    public void userIsLoggedIn() {
        LoginPage.enterEmail("abirocks007@gmail.com");
        LoginPage.enterPassword("PA33word!");
        LoginPage.clickLogin();

    }
}
