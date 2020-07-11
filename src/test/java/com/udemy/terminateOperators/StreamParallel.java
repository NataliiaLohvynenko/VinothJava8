package com.udemy.terminateOperators;

import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StreamParallel {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void getDriver(@Optional("chrome") String browser) {
        driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkedTest() {
        this.driver.get("https://www.google.com/");

        System.out.println("Before " + LocalDateTime.now());
        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(e-> e.getAttribute("href"))
                .filter(src->LinkUtil.getResponseCode(src)!=200)
                .collect(Collectors.toList());

        System.out.println("After " + LocalDateTime.now());
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
