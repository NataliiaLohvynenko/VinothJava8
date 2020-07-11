package com.udemy.test;

import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.Keys;

import java.util.List;

public class DriverTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);


    }

    @Test
    public void googleTest() {
        this.driver.get("https://www.google.com/");
        List<WebElement> elements = this.driver.findElements(By.tagName("a"));
        //    elements.forEach(e -> System.out.println(e.getText()));
       /* Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() ==0;
        Predicate<WebElement> containsS = (e) -> e.getText().toUpperCase().contains("S");*/
        // elements.forEach((e)->System.out.println(e.getText().toUpperCase().contains("S")));

        // elements.removeIf(containsS.or(isBlank));

        // elements.removeIf((e)-> e.getText().trim().length() == 0);

        //  Rules.get().forEach(rule -> elements.removeIf(rule));

      /*  Rules.get().forEach(elements::removeIf);
       elements.forEach(e -> System.out.println(e.getText()));*/

        elements.stream()
                .map(WebElement::getText)
                .filter(e -> e.trim().length() != 0)
                .map(String::toUpperCase)//e -> e.toUpperCase())
                .filter(e -> !e.contains("S"))
                .forEach(System.out::println);

    }



    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
