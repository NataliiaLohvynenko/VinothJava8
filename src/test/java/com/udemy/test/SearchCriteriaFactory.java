package com.udemy.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.openqa.selenium.WebElement;



public class SearchCriteriaFactory {

    private static Predicate<List<WebElement>> allMail = (l)->l.get(1).getText().equalsIgnoreCase("male");
    private static Predicate<List<WebElement>> allFemail = (l)->l.get(1).getText().equalsIgnoreCase("female");
    private static Predicate<List<WebElement>> allGender = allFemail.or(allFemail);
    private static  Predicate<List<WebElement>> usa = (l)->l.get(2).getText().equalsIgnoreCase("usa");
    private static Map<String, Predicate<List<WebElement>>> MAP = new HashMap<String, Predicate<List<WebElement>>>();
    static {
        MAP.put("allMale", allMail);
        MAP.put("allFemale", allFemail);
        MAP.put("usa", usa);
        MAP.put("allGender", allGender);
    }



    public static Predicate<List<WebElement>>  getCriteria(String criteriaName){
return MAP.get(criteriaName);
    }
}
