package com.udemy.supplier;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final Supplier<WebDriver> chromeSupplier = ()->{
      System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
      return new ChromeDriver();
    };
    private static final Supplier<WebDriver> fireFoxSupplier = ()->{
        System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox", fireFoxSupplier);
    }

    public static WebDriver getDriver(String browser){

        return MAP.get(browser).get();
    }

}
