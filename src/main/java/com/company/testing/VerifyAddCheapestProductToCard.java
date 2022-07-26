package com.company.testing;

import com.company.pages.CartPage;
import com.company.pages.LogInPage;
import com.company.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.HashMap;

public class VerifyAddCheapestProductToCard extends BaseTest {
    @Test
    public void verifyAddCheapestProduct() {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        CartPage cartPage = new CartPage(driver);

        ProductPage productPage = new ProductPage(driver);
        productPage.openPage();
        Assert.assertEquals(productPage.isDisplayed(), true, "Login failed");
        Double lowestPrice = productPage.getCheapestItem();
        String strLowestPrice = "$" + lowestPrice.toString();
        productPage.clickCartContainer();
        Assert.assertEquals(cartPage.isDisplayed(),true, "Cart page didn`t open");
        boolean priceFound = cartPage.VerifyAddItemByPrice(strLowestPrice);
        Assert.assertEquals(priceFound,true,"Item with lowest price is not in the cart");


    }

    @Test
    public void VerifyAddCheapestProductToCardAfterSort() {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setDriver(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();
        CartPage cartPage = new CartPage(driver);
        cartPage.openPage();
        HashMap<String, Integer> cartList = cartPage.verifyItemNumberInCart();
        Assert.assertEquals(cartList.size(),0,"Your cart is not empty");
        ProductPage productsPage = new ProductPage(driver);
        productsPage.openPage();
        Assert.assertEquals(productsPage.isDisplayed(), true, "Login failed");
        productsPage.selectLowToHigh();
        productsPage.addFirstItemFromList();
        String actualCheapestProductName = cartPage.getFirstProductName().getText();
        Assert.assertEquals(actualCheapestProductName,"Sauce Labs Onesie","Chrapest product is not in the cart");




    }

}




