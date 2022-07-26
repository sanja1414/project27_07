package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage2 extends BasePage {
    public CheckoutPage2(WebDriver driver) {
        super(driver);
        this.url = "https://www.saucedemo.com/checkout-step-two.html";


    }
    public CheckoutPage2(){

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
    private WebElement getBtnFinish(){
        return driver.findElement(By.id("finish"));
    }
    public void btnFinish(){
        this.getBtnFinish().click();
    }
}
