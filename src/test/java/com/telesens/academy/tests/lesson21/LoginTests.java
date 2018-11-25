package com.telesens.academy.tests.lesson21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTests {


    private WebDriver driver;
    private String baseUrl;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) throws Exception {

        switch (browser) {
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "/Users/allekso/Ide/**/aProjects/javapart-alexey-usatenko/files/chromedriver");
                System.setProperty("webdriver.chrome.driver", "C:/Users/Lex/IdeaProjects/javapart-alexey-usatenko/files/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "/Users/allekso/IdeaProjects/javapart-alexey-usatenko/files/geckodriver");
                System.setProperty("webdriver.gecko.driver", "C:/Users/Lex/IdeaProjects/javapart-alexey-usatenko/files//geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            default:
                throw new UnsupportedOperationException("Not supported browser: " + browser);
        }

        baseUrl = "http://store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(groups = {"login", "negative"}, dataProvider = "negativeLoginProvider")
    public void testNegativeLogin(String login, String password, String errMessage) throws Exception {
        driver.get(baseUrl);
        WebElement myAccountLink = driver.findElement(By.className("account_icon"));
        myAccountLink.click();
        WebElement usernameField = driver.findElement(By.id("log"));
        usernameField.clear();
        usernameField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.id("pwd"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(3000); // bad practice
//        waitForJSandJQueryToLoad();
//        WebElement message = driver.findElement(By.className("response"));
//        WebElement message = driver.findElement(By.xpath("//p[@class='response']/strong[contains(.,'ERROR')]/../text"));
        WebElement message = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.className("response")));
        Assert.assertEquals(message.getText(), errMessage);
    }

    @AfterClass
    public void setDown() {
        driver.quit();
    }

    @DataProvider(name = "negativeLoginProvider")
    public Object[][] negativeLoginProvider() {
        return new Object[][]{
                {"Iraa", "passpass123passpass", "ERROR: Invalid username. Lost your password?"}
        };
    }

    protected boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                // no jQuery present
                return true;
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}