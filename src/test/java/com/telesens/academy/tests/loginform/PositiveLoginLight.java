package com.telesens.academy.tests.loginform;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class PositiveLoginLight {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("firefox") String browser) throws Exception {
        ReadProperty prop = new ReadProperty();
        String propFile = "drivers.properties";
        String driverPath = prop.readProperty(propFile, "firefoxWindowsHomeDriver.url");
        switch (browser) {
            case "chrome":
                driverPath = prop.readProperty(propFile, "chromeWindowsHomeDriver.url");
                System.setProperty("webdriver.chrome.driver", "driverPath");
                driver = new ChromeDriver();
                break;

            case "firefox":
                driverPath = prop.readProperty(propFile, "firefoxWindowsHomeDriver.url");
                System.setProperty("webdriver.gecko.driver", "driverPath");
                driver = new FirefoxDriver();
                break;

            default:
                throw new UnsupportedOperationException("Not supported browser: " + browser);
        }

        baseUrl = "http://store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(groups = {"login", "positive"})
    public void testPositiveLoginLight() throws Exception {
        driver.get("http://store.demoqa.com/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cart'])[1]/following::span[2]")).click();
        driver.findElement(By.id("account")).click();
        driver.findElement(By.id("log")).click();
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("89789766Test");
        driver.findElement(By.id("log")).clear();
        driver.findElement(By.id("log")).sendKeys("ajjekso@gmail.com");
        driver.findElement(By.id("login")).click();
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
