package com.udemy.test.hoverableTest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class HoverableTest {

    private  WebDriver driver;

    private Actions actions;

    @BeforeTest
    @Parameters
    public void getBrowser(@Optional("chrome") String browser){
        this.driver = DriverFactory.getDriver(browser);
        actions = new Actions(driver);
    }

    @Test(dataProvider = "linkProvider")
    public void hoverableDropdownTest(String path){
      driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        String[] split = path.split("=>");
        Arrays.stream(split)
                .map(s->s.trim())
                .map(s-> By.linkText(s))
                .map(by ->driver.findElement(by))
                .map(ele->actions.moveToElement(ele))
                .forEach(a->a.perform());
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);



        WebElement dropdown = driver.findElement(By.linkText("Dropdown2"));
        
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

    @DataProvider(name = "linkProvider")
    public Object [] testdata(){
        return new Object[]{
                "Dropdown => Dropdown Link 2",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4=> Dropdown Submenu Link 5.4.2"
        };
    }

}
