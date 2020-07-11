package com.udemy.test;

import com.udemy.Pages.TablePage;
import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.util.List;
import java.util.function.Predicate;

public class CheckboxTest {

    WebDriver driver;
    private TablePage tablePage;


    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser) {
        driver = DriverFactory.getDriver(browser);
        this.tablePage = new TablePage(driver);
    }

    @Test(dataProvider = "criteriaProvider")
    public void CheckboxTest(Predicate<List<WebElement>> searchCriteria) {
        //driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        tablePage.goTo();
       //tablePage.selectRows(searchCriteria);
        tablePage.selectRows(searchCriteria);


    }

    @AfterTest
    public void driverClose() {
        driver.close();
    }

    @DataProvider(name="criteriaProvider")
    public Object[] tesData() {

        return new Object[]{
                SearchCriteriaFactory.getCriteria("allMale")
        };
    }
}
