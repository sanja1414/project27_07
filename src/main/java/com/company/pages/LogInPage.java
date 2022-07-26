package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class LogInPage extends BasePage {

        private WebDriver driver;
        private WebElement inpUserName;
        private WebElement inpPassword;
        private WebElement btnLogin;
        private String url;

        public LogInPage(WebDriver driver) {
            super(driver);
            this.url = super.url;
        }
        public LogInPage() {

        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }



        public WebDriver getDriver() {
       return driver;
        }

       public void setDriver(WebDriver driver) {
        this.driver = driver;
        }

        public WebElement getInpUserName() {
            return driver.findElement(By.id("user-name"));
        }

        public void setInpUserName(WebElement inpUserName) {
        this.inpUserName = inpUserName;
        }

        public WebElement getInpPassword() {
            return driver.findElement(By.id("password"));
        }

        public void setInpPassword(WebElement inpPassword) {
        this.inpPassword = inpPassword;
        }

        public WebElement getBtnLogin() {
            return driver.findElement(By.id("login-button"));
        }

        public void setBtnLogin(WebElement btnLogin) {
        this.btnLogin = btnLogin;
        }

        public void openPage() {
            driver.get(url);
            driver.manage().window().maximize();;
        }

        public void setUserName(String userName) {
            this.getInpUserName().sendKeys(userName);
        }

        public void setPassword(String password) {
            this.getInpPassword().sendKeys(password);
        }

        public void clickOnLogin() {
            WebElement btnLogin = this.getBtnLogin();
            this.getBtnLogin().click();
        }

        public void closePage() {
            driver.close();
            driver.quit();
        }
        }

