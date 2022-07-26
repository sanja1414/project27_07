package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class ProductPage extends BasePage {

    public WebDriver getDriver() {

        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.saucedemo.com/inventory.html";
    }

    public void openPage() {
        driver.get(this.url);
        driver.manage().window().maximize();
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

    public void addProductByName(String name) {
        WebElement listInventoryContainer = driver.findElement(By.id("inventory_container"));
        List<WebElement> listInventoryItem = listInventoryContainer.findElements(By.className("inventory_item"));
        Integer IndexElement = -1;
        for (int i = 0; i < listInventoryItem.size(); i++) {
            WebElement inventoryName = listInventoryItem.get(i).findElement(By.className("inventory_item_name"));
            if (inventoryName.getText().equals(name)) {
                IndexElement = i;
                break;
            }
        }
        WebElement btnAdd = listInventoryItem.get(IndexElement).findElement(By.xpath(".//button"));
        btnAdd.click();

    }

    private WebElement getSortContainer() {
        return driver.findElement(By.xpath(".//select[@class='product_sort_container']"));
    }


    public Double getCheapestItem() {
        List<WebElement> listAddToCartBtn = driver.findElements(By.xpath("//button"));
        List<WebElement> listItemsPrices = driver.findElements(By.className("inventory_item_price"));
        double lowestPrice = 100000.0;

        WebElement lowestPriceBtn = null;

        for (int i = 0; i < listItemsPrices.size(); i++) {
            Double price = Double.parseDouble(listItemsPrices.get(i).getText().substring(1));
            if (price < lowestPrice) {
                lowestPrice = price;
                lowestPriceBtn = listItemsPrices.get(i).findElement(By.xpath("following-sibling::button"));
            }
        }
        lowestPriceBtn.click();
        System.out.println(lowestPrice);
        return lowestPrice;


    }
    public void addFirstItemFromList(){
        WebElement itemContainer = driver.findElement(By.id("inventory_container"));
        itemContainer.findElement(By.xpath(".//button")).click();

    }

    private WebElement getLowToHighItemFromList() {
        return driver.findElement(By.xpath(".//option[@value='lohi']"));
    }

    public void selectLowToHigh() {
        this.getSortContainer().click();
        this.getLowToHighItemFromList().click();
    }

    private WebElement getCartContainer() {
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public void clickCartContainer() {
        this.getCartContainer().click();

    }

}


