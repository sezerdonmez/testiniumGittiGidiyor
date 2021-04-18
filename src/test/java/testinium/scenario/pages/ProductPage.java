package testinium.scenario.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testinium.scenario.main.MainClass;

import java.util.List;

import static testinium.scenario.elements.Elements.*;

public class ProductPage extends MainClass {

    public ProductPage(WebDriver wDriver){

        this.driver = wDriver;

    }

    public void addToBasket(){

        WebElement addBasket = driver.findElement(addBasketButton);
        scrollToElement(addBasket);
        addBasket.click();
        wait(3);
    }

    public String realProductPrice(){

        String productPrice = driver.findElement(productPriceText).getText();
        return productPrice;

    }

    public void  goToBasket(){

        WebDriverWait waitMe = new WebDriverWait(driver,30);
        waitMe.until(ExpectedConditions.presenceOfElementLocated(basket));
        WebElement toBasket = driver.findElement(basket);
        toBasket.click();

    }
}
