package testinium.scenario.test;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testinium.scenario.main.MainClass;
import testinium.scenario.pages.*;

import java.util.concurrent.TimeUnit;

public class MainTest extends MainClass {

@Before
    public void setup(){
        try{
            PropertyConfigurator.configure("log4j.properties");
            logger.info("Test has started");
            System.setProperty("webdriver.chrome.driver","ChromeDriver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            options.addArguments("--ignore-certificate-errors");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
@Test
    public void testiniumScenario(){
    try {
        FirstPage firstPage = new FirstPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        firstPage.openPage();
        firstPage.checkTitles();
        firstPage.login();
        loginPage.enterIdPass();
        loginPage.pressLogin();
        firstPage.checkLogin();
        firstPage.searchProduct();
        searchPage.mouseScrollDown();
        searchPage.goSecondProductPage();
        searchPage.checkTitles();
        WebElement product = searchPage.chooseRandomProduct();
        searchPage.goProductPage(product);
        productPage.addToBasket();
        String realProductPrice = productPage.realProductPrice();
        productPage.goToBasket();
        String actualProductPrice = basketPage.priceInBasket();
        basketPage.comparePrices(realProductPrice,actualProductPrice);
        basketPage.countOfProduct("2");
        basketPage.controlCountOfProduct(actualProductPrice);
        basketPage.deleteProductFromBasket();
        basketPage.controlBasket();

    }catch (Exception e){
        e.printStackTrace();
    }

    }
@After
    public void quit(){

        try {

            driver.quit();
            logger.info("Test finished");

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}
