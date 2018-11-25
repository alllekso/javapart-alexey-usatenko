package com.telesens.academy.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class RecorderTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;

    //***********************************************************
    //Почему мы используем стринг буфер, а не стринг, как обычно?
    //***********************************************************

    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
//    System.setProperty("webdriver.chrome.driver", "/Users/allekso/IdeaProjects/javapart-alexey-usatenko/automation/geckodriver"); chrome
//        System.setProperty("webdriver.gecko.driver", "/Users/allekso/IdeaProjects/javapart-alexey-usatenko/automation/geckodriver"); mac
        System.setProperty("webdriver.chrome.driver", "C:/Users/Lex/IdeaProjects/javapart-alexey-usatenko/files/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.google.com/search?q=test&ie=utf-8&oe=utf-8&client=firefox-b-ab");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test — Википедия'])[1]/following::cite[1]")).click();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("ajjekso@gmail.com");
        driver.findElement(By.id("create-account_form")).submit();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("alexey");
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("usatenko");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("89789766Test");
        driver.findElement(By.id("days")).click();
        new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:1\\s+");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::option[2]")).click();
        driver.findElement(By.id("months")).click();
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::option[34]")).click();
        driver.findElement(By.id("years")).click();
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2018\\s+");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::option[47]")).click();
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("test");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("MyCity");
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alaska");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Alaska'])[1]/following::option[3]")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("888888");
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys("380996542857");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("test 34");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Apartment, suite, unit, building, floor, etc...'])[1]/following::p[1]")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("other")).click();
        driver.findElement(By.id("other")).clear();
        driver.findElement(By.id("other")).sendKeys("test");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("000000");
        driver.findElement(By.id("submitAccount")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("89789766Test");
        driver.findElement(By.id("account-creation_form")).click();
        driver.findElement(By.id("submitAccount")).click();
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
