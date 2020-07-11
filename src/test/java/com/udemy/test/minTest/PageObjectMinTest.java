package com.udemy.test.minTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class PageObjectMinTest {

    private final WebDriver driver;

    @FindBy(className = "price")
    private List<WebElement> prices;

    @FindBy(css = "table#prods tr")
    private List<WebElement> elements;

    @FindBy(id = "result")
    private WebElement verify;

    @FindBy(id = "status")
    private WebElement status;

    public PageObjectMinTest(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
    }

    public String getMinPrice() {
        String strmin;
        // List<WebElement> prices = driver.findElements(By.className("price"));
        OptionalInt min1 = prices.stream()
                .map(e -> Integer.parseInt(e.getText()))
                .mapToInt(a -> a)
                .min();

        int min = min1.getAsInt();

        strmin = Integer.toString(min);

        return strmin;
    }


    public void selectMinPrice() {

        Optional<List<WebElement>> minRow = elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
                .min(Comparator.comparing(tdlist -> Integer.parseInt(tdlist.get(2).getText())));

        if (minRow.isPresent()){
            List<WebElement> cells =minRow.get();
            cells.get(3).findElement(By.tagName("input")).click();
        }

    }

    public void clickPrice(String min) {
        //  List<WebElement> elements = driver.findElements(By.xpath("//table[1]//tr"));
        elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
        // .peek(e-> System.out.println(e.size()))
        // .forEach(e-> System.out.println(e.size()));


                .peek(e-> System.out.println(e.get(2).getText()))
                // .filter(e -> e.get(2).getText().equals(strmin))
                .filter(l->l.get(2).getText().equalsIgnoreCase(min))
                .peek(e-> System.out.println("ufter" + e.get(2).getText()))
                .map(e->e.get(3).findElement(By.className("radio")))
                .forEach(e ->  e.click());
    }

    public String getStatus() {

        // WebElement verify = driver.findElement(By.id("result"));
        verify.click();

        return status.getText().trim();//driver.findElement(By.id("status")).getText();

    }


}
