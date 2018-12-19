package com.telesens.academy.tests.lesson21;

import com.telesens.academy.automationSuppotClasses.ReadProperty;
import com.telesens.academy.tests.demoqa.page.MainPage;
import com.telesens.academy.tests.demoqa.page.YourAccountPage;
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
    public void setUp(@Optional("firefox") String browser) throws Exception {
        ReadProperty prop = new ReadProperty();
        String propFile = "drivers.properties";
        switch (browser) {
            case "chrome":
//                String driverPath = prop.readProperty(propFile, "chromeHome.url");
//                String driverPath = prop.readProperty(propFile,"chromeWork.url");
                String driverPath = prop.readProperty(propFile, "chromeMac.url");
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;

            case "firefox":
//                driverPath = prop.readProperty(propFile, "firefoxHome.url");
//                driverPath = prop.readProperty(propFile, "firefoxWork.url");
                driverPath = prop.readProperty(propFile, "firefoxMac.url");
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                break;

            default:
                throw new UnsupportedOperationException("Not supported browser: " + browser);
        }

        baseUrl = "http://store.demoqa.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test(dataProvider = "negativeLoginProvider")
    public void testNegativeLogin(String login, String password, String errMessage) throws Exception {
//        driver.get(baseUrl);
        // Длинно
        MainPage mainPage = new MainPage(driver);
        mainPage.goToHome();
        YourAccountPage yourAccountPage = mainPage.clickToMyAccount();

        // Коротко
//        new MainPage(driver)
//                .goToHome()
//                .mainPage().clickToMyAccount()
//                .yourAccountPage().enterLogin(login);

//        WebElement usernameField = driver.findElement(By.id("log"));
//        usernameField.clear();
//        usernameField.sendKeys(login);
//        YourAccountPage yourAccountPage = new YourAccountPage(driver);
//        yourAccountPage.enterLogin(login);
        WebElement passwordField = driver.findElement(By.id("pwd"));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
//        Thread.sleep(3000); // bad practice
//        waitForJSandJQueryToLoad();
//        WebElement message = driver.findElement(By.className("response"));
        WebElement message = driver.findElement(By.xpath("//p[@class='response'][contains(.,'ERROR')]"));
//        WebElement message = (new WebDriverWait(driver, 7))
//                .until(ExpectedConditions
//                        .presenceOfElementLocated(By.className("response")));
        Assert.assertEquals(message.getText(),errMessage);
        // Veri
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