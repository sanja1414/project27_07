package com.company.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

    public class BaseTest {
    protected static WebDriver driver;
    protected String url;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Sanja\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @AfterClass
    public void close() {
        this.driver.quit();
    }
}

