package com.udemy.test.minTest;

import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MinTest {

    WebDriver driver;
    PageObjectMinTest pageObjectMinTest;

    @BeforeTest
    @Parameters
    public void getDriver(@Optional("chrome") String browser) {
        driver = DriverFactory.getDriver(browser);
        pageObjectMinTest = new PageObjectMinTest(driver);
    }

    @Test
    public void MinTest() {

        pageObjectMinTest.goTo();
     /*   String minPrice = pageObjectMinTest.getMinPrice();
        pageObjectMinTest.clickPrice(minPrice);*/
     pageObjectMinTest.selectMinPrice();



        Assert.assertEquals( pageObjectMinTest.getStatus(), "PASS");
    /*    List<String> sr = new ArrayList<>();
                sr.add("3");
                sr.add("5");

        OptionalInt min = sr.stream()
                .map(e -> Integer.parseInt(e))
                .mapToInt(a -> a)
                .min();
        System.out.println(min);*/

/*

        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
*/

     /*   List<WebElement> prices = driver.findElements(By.className("price"));
        OptionalInt min1 = prices.stream()
                .map(e -> Integer.parseInt(e.getText()))
                .mapToInt(a -> a)
                .min();

        int min = min1.getAsInt();

        String strmin = Integer.toString(min);

        System.out.println("strmin : " +strmin);

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        List<WebElement> elements = driver.findElements(By.xpath("//table[1]//tr"));
        elements.stream()
                .skip(1)
                .map(tr -> tr.findElements(By.tagName("td")))
               // .peek(e-> System.out.println(e.size()))
               // .forEach(e-> System.out.println(e.size()));


                .peek(e-> System.out.println(e.get(2).getText()))
               // .filter(e -> e.get(2).getText().equals(strmin))
                .filter(l->l.get(2).getText().equalsIgnoreCase(strmin))
                .peek(e-> System.out.println("ufter" + e.get(2).getText()))
                .map(e->e.get(3).findElement(By.className("radio")))
                .forEach(e ->  e.click());



       Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

       WebElement click = driver.findElement(By.id("result"));
       click.click();

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        Assert.assertEquals(driver.findElement(By.id("status")).getText(), "PASS");
*/
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
