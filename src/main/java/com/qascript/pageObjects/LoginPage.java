package com.qascript.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public static String txtEmail="(//input[@type='text'])[2]";
    public static String txtPassword="//input[@type='password']";
    public static String btnLogin="(//span[text()='Login'])[2]";
    public static String lblUsername = "(//*[@class='exehdJ'])[1]";
    public static String lblError = "//*[@class='_2YULOR']/span";

    public static WebDriver driver;

    public static void enterEmail(String username){
        driver.findElement(By.xpath(txtEmail)).sendKeys(username);
    }

    public static void enterPassword(String password){
        driver.findElement(By.xpath(txtPassword)).sendKeys(password);
    }

    public static void clickLogin(){
        driver.findElement(By.xpath(btnLogin)).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblUsername)));
    }

    public static void validateSuccessfulLogin(String expectedText){
        String text = driver.findElement(By.xpath(lblUsername)).getText();
        Assert.assertEquals(expectedText,text);
    }

    public static void validateUnsuccessfulLogin(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,30);
        String text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblError))).getText();
        Assert.assertTrue(text.equals(expectedText));
    }
}
