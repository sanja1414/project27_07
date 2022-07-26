package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage1 extends BasePage {
    public CheckoutPage1(WebDriver driver) {
        super(driver);
        this.url = "https://www.saucedemo.com/checkout-step-one.html";


    }
    public CheckoutPage1(){

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
    private WebElement inputFirstName(){
        return driver.findElement(By.id("first-name"));
    }
    public void setFirstName(String firstName){
        this.inputFirstName().sendKeys(firstName);
    }
    private WebElement inputLastName(){
        return driver.findElement(By.id("last-name"));
    }
    public void setLastName(String lastName){
        this.inputLastName().sendKeys(lastName);
    }
    private WebElement inputZipCode(){
        return driver.findElement(By.id("postal-code"));
    }
    public void setZipCode(String zipCode){
        this.inputZipCode().sendKeys(zipCode);
    }
    private WebElement getBtnContinue(){
        return driver.findElement(By.id("continue"));
    }
    public void btnContinue(){
        this.getBtnContinue().click();
    }
}
