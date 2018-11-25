package com.telesens.academy.tests.loginform;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class PositiveLoginLight {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Lex/IdeaProjects/javapart-alexey-usatenko/files//geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://store.demoqa.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testPositiveLoginLight() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.linkText("AccountMy Account")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("log")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("pwd")).clear();
        Thread.sleep(3000);

        driver.findElement(By.id("pwd")).sendKeys("89789766Test");
        Thread.sleep(3000);

        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("ajjekso@gmail.com");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::label[1]")).click();
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("AccountMy Account")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Log out")).click();
        driver.findElement(By.linkText("ONLINE STORE")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
