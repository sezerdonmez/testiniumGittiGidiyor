package testinium.scenario.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testinium.scenario.main.MainClass;

import java.util.List;

import static testinium.scenario.elements.Elements.*;

public class SearchPage extends MainClass {

    public SearchPage(WebDriver wDriver) {

        this.driver = wDriver;

    }

    public void mouseScrollDown() {

        WebElement productPageNumber = driver.findElement(choosePage);
        scrollToElement(productPageNumber);

    }

    public void goSecondProductPage() {

        WebElement productSecondPage = driver.findElement(searchSecondPageButton);
        productSecondPage.click();

    }

    public void checkTitles() {

        String actualTitle = driver.getTitle();
        if (actualTitle.equals(desiredTitleSearchPage)) {
            logger.info("Titles equal, Second product page opened");
        } else {
            logger.error("Titles different, Second product opening failure");
        }
    }

    public WebElement chooseRandomProduct() {

        List<WebElement> productsInSearchPage = driver.findElements(allProductsInPage);
        WebElement randomProduct = findRandomElement(productsInSearchPage);
        scrollToElement(randomProduct);
        return randomProduct;
    }

    public void goProductPage(WebElement randomElement){

        randomElement.click();

    }
}
