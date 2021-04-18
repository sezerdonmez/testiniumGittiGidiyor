package testinium.scenario.main;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

import static testinium.scenario.elements.Elements.priceTextInBasket;

public class MainClass  {

    public WebDriver driver;
    public final static Logger logger = Logger.getLogger(testinium.scenario.main.MainClass.class);
    public static final String testPageUrl              = "https://www.gittigidiyor.com";
    public static final String desiredTitleFirstPage    = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
    public static final String desiredTitleSearchPage   = "Bilgisayar - GittiGidiyor - 2/100";
    public static final String desiredEmptyText         = "Sepetinizde ürün bulunmamaktadır.";
    public static final String eMail                    = "********";
    public static final String password                 = "********";
    public static final String desiredValidLogText      = "Hesabım";

    public void scrollToElement(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public WebElement findRandomElement(List<WebElement> elements){

        Random findRandomly = new Random();
        WebElement product = elements.get(findRandomly.nextInt(elements.size()));
        int endOfLineIndex = product.getText().indexOf("\n");
        logger.info(product.getText().substring(0,endOfLineIndex) + " chosen by randomly");
        return product;
    }

    public void wait(int secs){
        try {
            Thread.sleep(secs*1000);
            logger.info(secs + " seconds slept");
        }
        catch (Exception e){
            logger.error("Failure while sleeping");
            e.printStackTrace();
        }
    }

    public void chooseFromDropDownBox(WebElement element, String whichOne){

        Select productCount = new Select(element);
        productCount.selectByValue(whichOne);

    }

    public String getPriceText(By by){
        WebElement actualPrice = driver.findElement(by);
        String priceText = actualPrice.getText();
        return priceText;
    }

}
