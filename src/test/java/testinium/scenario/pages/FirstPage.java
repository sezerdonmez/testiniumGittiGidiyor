package testinium.scenario.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import testinium.scenario.elements.Elements;
import testinium.scenario.main.MainClass;

import static testinium.scenario.elements.Elements.*;

public class FirstPage extends MainClass {
    public FirstPage(WebDriver wDriver){

        this.driver = wDriver;
    }

    public void openPage(){

        logger.info("Test page URL: " + testPageUrl);
        driver.get(testPageUrl);

    }

    public void checkTitles(){

        String actualTitle = driver.getTitle();
        if(actualTitle.equals(desiredTitleFirstPage)){
            logger.info("Main page has opened");
        }
        else {
            logger.error("Main page opening failure");
        }
    }

    public void login(){

        Actions logAction = new Actions(driver);
        WebElement toLogIn = driver.findElement(scrollToLogin);
        logAction.moveToElement(toLogIn).perform();
        wait(3);
        WebElement logMeIn = driver.findElement(loginMainButton);
        logMeIn.click();
    }

    public void checkLogin(){

        WebElement validLogin = driver.findElement(userInfo);
        String validateLogin = validLogin.getText().substring(0,7);
        if(validateLogin.equals(desiredValidLogText)){
            logger.info("Login process valid");
        }
        else {
            logger.error("Failure at login phase");
        }
    }

    public void searchProduct() {

        WebElement search = driver.findElement(searchInput);
        search.sendKeys("bilgisayar");
        search.sendKeys(Keys.ENTER);

     }
}
