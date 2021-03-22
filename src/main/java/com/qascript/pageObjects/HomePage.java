package com.qascript.pageObjects;

import com.qascript.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {

    public static String txtSearch = "//input[@name='q']";
    public static String linkLowToHighPrice = "//*[text()='Price -- Low to High']";
    public static String linkFirstProduct = "(//*[text()='APPLE iPhone 11 (White, 64 GB)'])[1]";
    public static String btnAddToCart = "//button[text()='ADD TO CART']";
    public static String btnPaceOrder = "//*[text()='Place Order']//ancestor::button[1]";


    public static void enterTextIntoSearch(String text){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(txtSearch))));
        driver.findElement(By.xpath(txtSearch)).click();
        driver.findElement(By.xpath(txtSearch)).sendKeys(text);
        driver.findElement(By.xpath(txtSearch)).sendKeys(Keys.ENTER);

    }

    public static void clickLinkLowToHigh(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(linkLowToHighPrice))));
        driver.findElement(By.xpath(linkLowToHighPrice)).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void clickFirstProduct(){
        driver.findElement(By.xpath(linkFirstProduct)).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    public static void addProductToCart(){
        String parentWindow = driver.getWindowHandle();
        Set<String> windows  = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while(iterator.hasNext())
        {
            String childWindow = iterator.next();
            if(!parentWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.findElement(By.xpath(btnAddToCart)).click();
            }
        }
        driver.switchTo().window(parentWindow);


    }


}
