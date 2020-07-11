package com.udemy.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Rules {

    private static Predicate<WebElement> isBlank = (e) -> e.getText().trim().length() == 0;
    private static Predicate<WebElement> containsS = (e) -> e.getText().toUpperCase().contains("S");

    public static List<Predicate<WebElement>> get() {

        List<Predicate<WebElement>> rule = new ArrayList<>();
        rule.add(isBlank);
        rule.add(containsS);
        return rule;
    }
}
