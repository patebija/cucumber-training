package com.qascript.stepDefinitions;

import com.qascript.pageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefs {

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        driver.quit();
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
        driver.get("https://www.flipkart.com");
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
}
