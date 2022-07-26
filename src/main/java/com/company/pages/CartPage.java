package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.saucedemo.com/cart.html";


    }

    public CartPage() {
    }

    public void openPage() {
        driver.get(this.url);
    }

    public Boolean isDisplayed() {
        Boolean toReturn = true;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public void closePage() {
        driver.quit();
    }


    public HashMap<String, Integer> verifyItemNumberInCart() {

        HashMap<String, Integer> returnValue = new HashMap<>();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));

        for (int i = 0; i < cartItems.size(); i++) {
            String cartItem = cartItems.get(i).findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if (returnValue.containsKey(cartItem)) {
                int tempCount = returnValue.get(cartItem);
                returnValue.put(cartItem, tempCount + 1);
            } else {
                returnValue.put(cartItem, 1);
            }

        }

        return returnValue;
    }

    public boolean VerifyAddItemByName(String name) {
        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
        boolean ItemFound = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getText().equals(name)) {
                ItemFound = true;
                break;
            }
        }
        return ItemFound;

    }

    public boolean VerifyAddItemByPrice(String price) {
        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_price"));
        boolean ItemFound = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getText().equals(price)) {
                ItemFound = true;
                break;
            }
        }
        return ItemFound;
    }


    private WebElement getBtnRemove() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public void btnRemove() {
        this.getBtnRemove().click();
    }

    private WebElement getBtnCheckout() {
        return driver.findElement(By.id("checkout"));
    }

    public void btnCheckout() {
        this.getBtnCheckout().click();
    }

    public Double getSumOfAllItems() {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        double sum = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            String tempPrice = prices.get(i).getText().substring(1);
            sum = sum + Double.parseDouble(tempPrice);
        }
        return sum;


    }
    public WebElement getFirstProductName(){
        return driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
    }


}


