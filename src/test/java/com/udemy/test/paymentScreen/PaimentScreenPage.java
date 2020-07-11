package com.udemy.test.paymentScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class PaimentScreenPage {

    private WebDriver driver;

    PaymentDetails paymentDetails;

    @FindBy(id="coupon")
    private WebElement coupon;

    @FindBy(id ="couponbtn")
    private WebElement promoBtn;

    @FindBy(id="buy")
    private WebElement buy;

    @FindBy(id ="status")
    private WebElement status;

    @FindBy(id="cc")
    private WebElement cc;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id="cvv")
    private WebElement cvv;

    @FindBy(id ="couponbtn")
    private WebElement couponbtn;



    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }



    public PaimentScreenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
       // PageFactory.initElements(driver, PaymentDetails.class);
    }


    public void setCc(String cc) {
        this.cc.sendKeys(cc);
    }

    public void setYear(String year) {
        this.year.sendKeys(year);
    }

    public void setCvv(String cvv) {
        this.cvv.sendKeys(cvv);
    }

    public void setPromocode(String promocode) {
        this.coupon.sendKeys(promocode);
        this.couponbtn.click();
    }


    public String  getStatus(){
        buy.click();
        return status.getText().trim();
    }

    public Consumer<PaymentDetails> paymentScenario(String scenario){
         return PaymentDetailsFactory.getCC(scenario);
    }

   }


