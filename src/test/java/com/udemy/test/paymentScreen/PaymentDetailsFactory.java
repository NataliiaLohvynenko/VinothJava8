package com.udemy.test.paymentScreen;

import jdk.dynalink.beans.StaticClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PaymentDetailsFactory {

    private static String freePromoCode = "FREEUDEMY";
    private static String partialPromoCode = "PARTIALUDEMY";
    private static String validCc = "4111111111111111";
    private static String validYear = "2023";
    private static String validCvv = "123";
    private String invalidCc= "5111111111111111";
    private String invalidYear = "2020";



    static Consumer<PaymentDetails> freePromocode = (p)-> p.setPromocode(freePromoCode);
    static Consumer<PaymentDetails> partialPromocode = (p)-> p.setPromocode(partialPromoCode);

    static Consumer<PaymentDetails> validCC =(p)-> {
        p.setCc(validCc);
        p.setCvv(validCvv);
        p.setYear(validYear);
    };
    static Consumer<PaymentDetails> partialPromocodeValidCc =  partialPromocode.andThen(validCC);

    private static Map<String,Consumer<PaymentDetails>> MAP = new HashMap<>();
    static {
        MAP.put("freePromocode", freePromocode);
        MAP.put("validCC", validCC);
        MAP.put("partialPromocodeValidCc", partialPromocodeValidCc);

    }

    public static Consumer<PaymentDetails> getCC(String scenario){
        return  MAP.get(scenario);
    }







}
