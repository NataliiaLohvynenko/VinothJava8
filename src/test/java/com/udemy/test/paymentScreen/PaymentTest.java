package com.udemy.test.paymentScreen;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.supplier.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.udemy.test.paymentScreen.PaymentDetailsFactory.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class PaymentTest {

    WebDriver driver;
    PaimentScreenPage paimentScreenPage;
    PaymentDetailsFactory paymentDetailsFactory;

    @BeforeTest
    @Parameters
    public void getDriver(@Optional("chrome") String browser){
        driver = DriverFactory.getDriver(browser);
    }

    @Test(dataProvider = "testData")
    public void PaymentTest(Consumer/*<PaimentScreenPage*/<PaymentDetails> consumer){


        paimentScreenPage = new PaimentScreenPage(driver);
        paimentScreenPage.goTo();
        PaymentDetails paymentDetails = new PaymentDetails(driver);

        consumer.accept(paymentDetails);
       /* consumer.accept(paimentScreenPage);*/

        paimentScreenPage.getStatus();


        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        System.out.println(paimentScreenPage.getStatus());

    }


    @DataProvider(name = "testData")
    public Object[] testData(){
        return new Object[]{

               /* paimentScreenPage.paymentScenario("validCC")*/
                PaymentDetailsFactory.getCC("validCC"),
                /*PaymentDetailsFactory.getCC("partialPromocodeValidCc"),*/
                partialPromocodeValidCc,
                PaymentDetailsFactory.getCC("freePromocode")
                /*PaymentDetailsFactory.validCC*/
                /*PaymentDetailsFactory.freePromocode*/


        };
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
