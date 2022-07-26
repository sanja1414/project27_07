package com.company.testing;

import com.company.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTotalPriceInCart extends BaseTest{
    @Test
    public void VerifyTotalPriceInCart() {
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
        productPage.addProductByName("Sauce Labs Fleece Jacket");
        productPage.clickCartContainer();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.isDisplayed(), true, "Cart page didn`t open");
        Double totalSum = cartPage.getSumOfAllItems();
        Double finalTotal = totalSum*1.08;
        int pom = (int)Math.round(finalTotal*100);
        finalTotal=pom/100.0;
        System.out.println(finalTotal);
        cartPage.btnCheckout();
        CheckoutPage1 checkoutPage1 = new CheckoutPage1(driver);
        Assert.assertEquals(checkoutPage1.isDisplayed(),true,"Checkout page 1 is not opened");
        checkoutPage1.setFirstName("Sanja");
        checkoutPage1.setLastName("Angeleski");
        checkoutPage1.setZipCode("11500");
        checkoutPage1.btnContinue();
        CheckoutPage2 checkoutPage2 = new CheckoutPage2(driver);
        Assert.assertEquals(checkoutPage2.isDisplayed(),true,"Checkout page 2 is not opened");
        Assert.assertEquals(driver.findElement(By.className("summary_total_label")).getText(),"Total: $"+finalTotal.toString(),"Total is not correct");
    }
}



