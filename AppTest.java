package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import static java.lang.Thread.*;

public class AppTest
{
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://training.qastorming.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void Test() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.cssSelector("div.tg-site-footer-bar "));
        js.executeScript("arguments[0].scrollIntoView();", footer);
        Thread.sleep(5000);
        WebElement scrollButton = driver.findElement(By.cssSelector("a#tg-scroll-to-top"));
        scrollButton.click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
