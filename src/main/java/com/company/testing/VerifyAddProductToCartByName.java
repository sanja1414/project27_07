package com.company.testing;

import com.beust.ah.A;
import com.company.pages.CartPage;
import com.company.pages.LogInPage;
import com.company.pages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyAddProductToCartByName extends BaseTest{
    public void VerifyAddProductToCartByName(){
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductByName("Sauce Labs Backpack");
        productPage.clickCartContainer();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.isDisplayed(),true, "Cart page didn`t open");
        boolean itemByNameFound = cartPage.VerifyAddItemByName("Sauce Labs Backpack");
        Assert.assertTrue(itemByNameFound, "Item Sauce Labs Backpack is not in cart ");


    }
}
