package com.udemy.test;

import com.udemy.supplier.DriverFactory;
import com.udemy.terminateOperators.LinkUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    WebDriver driver;

    @BeforeTest
    @Parameters
    public void getBrowser(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
    }

    @Test
    public void linkTest() {
        driver.get("https://the-internet.herokuapp.com/broken_images");
       /* boolean result = driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .map(scr -> LinkUtil.getResponseCode(scr))
*//*                .filter(rc-> rc !=200)
                .count()*//*
                .anyMatch(rc -> rc != 200);


                *//*.forEach(src->{
                    System.out.println(LinkUtil.getResponseCode(src) + "src: " + src);
                });*//*
        Assert.assertTrue(result);*/

        List <String> list = driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(e -> e.getAttribute("src"))
                .filter(src-> LinkUtil.getResponseCode(src) != 200)
                .collect(Collectors.toList());

        Assert.assertEquals(list.size(),0);


    }

    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }

}
