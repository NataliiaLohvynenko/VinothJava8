package com.udemy.test.paymentScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetails extends PaimentScreenPage{

    WebDriver driver;
    public PaymentDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="cc")
    private WebElement cc;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id="cvv")
    private WebElement cvv;

    @FindBy(id="coupon")
    private WebElement promocode;

    @FindBy(id ="couponbtn")
    private WebElement promoBtn;



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
        this.promocode.sendKeys(promocode);
        promoBtn.click();
    }

}
