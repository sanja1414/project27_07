package com.company.testing;

import com.company.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyItemTotalPriceInCart extends BaseTest{
    @Test
    public void VerifyItemTotalPriceInCart(){
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductByName("Sauce Labs Backpack");
        productPage.addProductByName("Sauce Labs Bike Light");
        productPage.addProductByName("Sauce Labs Bolt T-Shirt");
        productPage.clickCartContainer();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.isDisplayed(),true, "Cart page didn`t open");
        Double totalSum = cartPage.getSumOfAllItems();
        cartPage.btnCheckout();
        CheckoutPage1 checkoutPage1 = new CheckoutPage1(driver);
        Assert.assertEquals(checkoutPage1.isDisplayed(),true,"Checkout page 1 is not opened");
        checkoutPage1.setFirstName("Sanja");
        checkoutPage1.setLastName("Angeleski");
        checkoutPage1.setZipCode("11500");
        checkoutPage1.btnContinue();
        CheckoutPage2 checkoutPage2 = new CheckoutPage2(driver);
        Assert.assertEquals(checkoutPage2.isDisplayed(),true,"Checkout page 2 is not opened");
        Assert.assertEquals(driver.findElement(By.className("summary_subtotal_label")).getText(),"Item total: $"+totalSum.toString(),"Item total is not correct");
    }
}
