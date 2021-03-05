package com.qascript.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.qascript.utils.PropertyUtils.loadProperties;

public class BaseClass {

    public static WebDriver driver;
    public static String url = loadProperties("src/test/resources/application.properties").getProperty("application.url");
    public static String chromePath = loadProperties("src/test/resources/framework.properties").getProperty("chrome.driver");

    public static void startDriver(){
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void launchApplication() {
        driver.get(url);
    }
}
