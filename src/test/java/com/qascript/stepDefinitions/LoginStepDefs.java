package com.qascript.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {

    public static String txtEmail="(//input[@type='text'])[2]";
    public static String txtPassword="//input[@type='password']";
    public static String btnLogin="(//span[text()='Login'])[2]";
    public static String lblUsername = "(//*[@class='exehdJ'])[1]";
    public static String lblError = "//*[@class='_2YULOR']/span";
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
        driver.findElement(By.xpath(txtEmail)).sendKeys(username);

    }

    @And("^User enters valid (.*) in EnterPassword field$")
    public void enterPassword(String password){
        driver.findElement(By.xpath(txtPassword)).sendKeys(password);

    }

    @When("^User clicks on Login button$")
    public void clickLoginButton(){
        driver.findElement(By.xpath(btnLogin)).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblUsername)));
    }

    @Then("^User is logged in successfully$")
    public void validateLogin(){
        String text = driver.findElement(By.xpath(lblUsername)).getText();
        Assert.assertEquals(text,"Abi");
    }


    @Given("Launch Flipkart application")
    public void launchFlipkartApplication() {
        driver.get("https://www.flipkart.com");
    }

    @Given("^User enters invalid (.*) in EnterUsername field$")
    public void userEntersInvalidUsernameInEnterUsernameField(String username) {
        driver.findElement(By.xpath(txtEmail)).sendKeys(username);
    }

    @And("^User enters invalid (.*) in EnterPassword field$")
    public void userEntersInvalidPasswordInEnterPasswordField(String password) {
        driver.findElement(By.xpath(txtPassword)).sendKeys(password);
    }

    @Then("User cannot login into application")
    public void userCannotLoginIntoApplication() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        String text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblError))).getText();
        Assert.assertTrue(text.equals("Your username or password is incorrect"));

    }
}
