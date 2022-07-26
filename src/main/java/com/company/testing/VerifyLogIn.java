package com.company.testing;

import com.company.pages.LogInPage;
import com.company.pages.ProductPage;
import com.company.provider.InvalidUser;
import com.company.provider.UserNameProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyLogIn extends BaseTest {
   @Test(dataProvider = "NonValidUserNameProvider", dataProviderClass = InvalidUser.class)
   public void VerifyLoginWithInValidCredentials(String userName) {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName(userName);
        loginPage.setPassword("secret_saucee");
        loginPage.clickOnLogin();
        ProductPage productsPage = new ProductPage(driver);
        productsPage.setDriver(driver);
        WebElement errMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals(errMsg.getText(), "Epic sadface: Username and password do not match any user in this service");


   }
     @Test(dataProvider = "NonValidUserNameProvider", dataProviderClass = InvalidUser.class)
     public void VerifyLoginWithInValidUserName(String userName) {
          LogInPage loginPage = new LogInPage(driver);
          loginPage.setDriver(driver);
          loginPage.openPage();
          loginPage.setUserName(userName);
          loginPage.setPassword("secret_sauce");
          loginPage.clickOnLogin();
          ProductPage productsPage = new ProductPage(driver);
          productsPage.setDriver(driver);
          WebElement errMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
          Assert.assertEquals(errMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
   }

    @Test(dataProvider = "NonValidPasswordProvider",dataProviderClass = InvalidUser.class)
    public void VerifyLoginWithNonValidPassword(String pss) {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword(pss);
        loginPage.clickOnLogin();
        WebElement errMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals(errMsg.getText(), "Epic sadface: Username and password do not match any user in this service");

    }


     @Test
     public void VerifyLoginWithValidCredentials() {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();
        ProductPage productPage = new ProductPage(driver);
        productPage.setDriver(driver);
        productPage.setUrl("https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productPage.isDisplayed(), true, "Login failed");

    }


}