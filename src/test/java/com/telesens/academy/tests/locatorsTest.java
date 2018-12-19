package com.telesens.academy.tests;

import com.telesens.academy.automationSuppotClasses.ReadProperty;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class locatorsTest {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Parameters("browser")
        @BeforeClass(alwaysRun = true)
        public void setUp(@Optional("firefox") String browser) throws Exception {
            ReadProperty prop = new ReadProperty();
            String propFile = "drivers.properties";
            switch (browser) {
                case "chrome":
                    String driverPath = prop.readProperty(propFile, "chromeWork.url");
//                String driverPath = prop.readProperty(propFile,"chromeWork.url");
//                String driverPath = prop.readProperty(propFile,"chromeMac.url");
                    System.setProperty("webdriver.chrome.driver", driverPath);
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driverPath = prop.readProperty(propFile, "firefoxWork.url");
//                driverPath = prop.readProperty(propFile, "firefoxWork.url");
//                driverPath = prop.readProperty(propFile, "firefoxMac.url");
                    System.setProperty("webdriver.gecko.driver", driverPath);
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new UnsupportedOperationException("Not supported browser: " + browser);
            }

            baseUrl = "http://store.demoqa.com";
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }

        @Test(groups = {"login", "positive"})
        public void testPositiveLoginLight() throws Exception {
            driver.get("https://f3.preprod.rocks");
            driver.findElement(By.cssSelector("a.pl-0:nth-child(1)")).click();
            driver.findElement(By.cssSelector("button.mr-3")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("BaseInputId-8")).clear();
            driver.findElement(By.id("BaseInputId-8")).sendKeys("cryptoparkqa@gmail.com");
            driver.findElement(By.id("BasePasswordInput-0")).clear();
            driver.findElement(By.id("BasePasswordInput-0")).sendKeys("89789766Test");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[3]/following::span[1]")).click();
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Slide to complete the puzzle'])[1]/following::div[1]")).click();
            Thread.sleep(3000);
            Thread.sleep(3000);
            Thread.sleep(3000);

            driver.findElement(By.cssSelector("button.is-m")).click();
            Thread.sleep(3000);
            Thread.sleep(3000);
            Thread.sleep(3000);
            driver.findElement(By.id("BaseInputId-13")).click();
            driver.findElement(By.id("BaseInputId-13")).clear();
            driver.findElement(By.id("BaseInputId-13")).sendKeys("5");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order confirmation'])[2]/following::button[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"BaseInputId-5\"]")).sendKeys("1");
            driver.findElement(By.xpath("//*[@id=\"BaseInputId-5\"]")).sendKeys(Keys.ENTER);
            System.out.println("Pressed Enter");
            Thread.sleep(3000);
            System.out.println("Wait 3 sec");
            driver.findElement(By.cssSelector("button.is-m:nth-child(1)")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order confirmation'])[1]/following::button[1]")).click();


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

