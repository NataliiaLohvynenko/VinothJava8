package com.udemy.Pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TablePage {
    private final WebDriver driver;

    public TablePage(WebDriver driver){
        this.driver=driver;
    }

    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
    }

    public void selectRows(Predicate<List<WebElement>> predicate){
        List<WebElement> checkbox =driver.findElements(By.tagName("tr"));
        checkbox.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))

                .filter(predicate)
                .map(tdList -> tdList.get(3))
                .map(td-> td.findElement(By.tagName("input")))
               // .collect(Collectors.toList());
                .forEach(e->e.click());

        List<WebElement> checkboxclicked =driver.findElements(By.tagName("tr"));
       int count = (int) checkboxclicked.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))

               // .filter(predicate)
                .map(tdList -> tdList.get(3))
                .map(td-> td.findElement(By.tagName("input")))
                .filter(wb-> !wb.isSelected())
                .count();
               // .collect(Collectors.toList());
               // .forEach(e->e.click());

        System.out.println(count);
       Assert.assertEquals(count,0);




    }
}
