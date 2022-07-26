package com.company.testing;

import com.company.pages.CartPage;
import com.company.pages.LogInPage;
import com.company.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyRemoveFromCart extends BaseTest{
   @Test
    public void VerifyRemoveFromCart(){
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
        cartPage.btnRemove();
       List<WebElement> listInventoryContainer = driver.findElements(By.id("inventory_container"));
       Assert.assertEquals(listInventoryContainer.size(), 0, "Item Sauce Labs Backpack is not removed");


    }
}
