package com.saucedemo.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<String> browserThreadLocal = new ThreadLocal<>();

    private WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            String browser = getBrowserName();
            driverThreadLocal.set(createDriver(browser));
        }
        return driverThreadLocal.get();
    }

    public static void setBrowser(String browser) {
        browserThreadLocal.set(browser);
    }

    public static String getBrowserName() {
        String browser = browserThreadLocal.get();
        if (browser == null) {
            browser = System.getProperty("browser", "chrome");
        }
        return browser.toLowerCase();
    }

    private static WebDriver createDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            case "firefox":
                logger.info("Initializing Firefox WebDriver");
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
            default:
                logger.info("Initializing Chrome WebDriver");
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            logger.info("Quitting WebDriver for browser: {}", getBrowserName());
            driver.quit();
            driverThreadLocal.remove();
            browserThreadLocal.remove();
        }
    }
}
