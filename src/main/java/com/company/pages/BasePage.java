package com.company.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
        protected WebDriver driver;
        protected String url;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            this.url = "https://www.saucedemo.com/";

        }

        public BasePage() {

        }

    public BasePage(WebDriver driver, String url) {

    }
}


