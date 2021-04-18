package testinium.scenario.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testinium.scenario.elements.Elements;
import testinium.scenario.test.MainTest;

import static testinium.scenario.elements.Elements.*;

public class BasketPage extends MainTest {

    public BasketPage(WebDriver wDriver){

        this.driver = wDriver;
    }



    public String priceInBasket(){

        String priceInBasket = getPriceText(priceTextInBasket);
        logger.info("Actual price: " + priceInBasket);
        return priceInBasket;

    }

    public void comparePrices(String realPrice, String actualPrice){

        if(realPrice.equals(actualPrice)){
            logger.info("Prices equal (Basket and Product Pages)");
        }
        else {
            logger.error("Prices different (Basket and Product Pages)");
        }
    }
    public void countOfProduct(String count){

        WebElement dropDownBox = driver.findElement(Elements.dropDownBox);
        chooseFromDropDownBox(dropDownBox,count);
        wait(2);

    }
    public void controlCountOfProduct(String priceOfOneProduct){
        WebElement dropDownBox = driver.findElement(Elements.dropDownBox);
        String twoProductsText = dropDownBox.getAttribute("value");

             if (twoProductsText.equals("2")){
                logger.info("Two products selected");
            }
            else {
                logger.error("Two products selecting failure");
            }

    }
    public void deleteProductFromBasket(){

        WebElement deleteButton = driver.findElement(deleteFromBasket);
        deleteButton.click();

    }
    public void controlBasket(){

        wait(2);
        WebElement emptyText = driver.findElement(productDeletedText);
        String actualText = emptyText.getText();
        if (actualText.equals(desiredEmptyText)){
            logger.info("Basket is empty");
        }
        else {
            logger.error("Basket is not empty");
        }

    }
}
