package testinium.scenario.elements;

import org.openqa.selenium.By;

public  class Elements {

    // FirstPage
    public static By scrollToLogin          = By.xpath("//div[@class='gekhq4-4 egoSnI']");
    public static By loginMainButton        = By.cssSelector("a[href='https://www.gittigidiyor.com/uye-girisi']");
    public static By userInfo               = By.xpath("//div[@class='gekhq4-4 egoSnI']");
    public static By searchInput            = By.name("k");
    public static boolean pullRequest       = true; // Trying pull requests

    // LoginPage
    public static By usernameInput          = By.id("L-UserNameField");
    public static By passwordInput          = By.id("L-PasswordField");
    public static By loginButton            = By.id("gg-login-enter");

    // SearchPage
    public static By choosePage             = By.xpath("//a[@class='current']");
    public static By searchSecondPageButton = By.cssSelector("a[href='/arama/?k=bilgisayar&sf=2']");
    public static By allProductsInPage      = By.xpath("//div[@class='product-info-con clearfix ']");

    //ProductPage
    public static By addBasketButton        = By.id("add-to-basket");
    public static By productPriceText       = By.id("sp-price-discountPrice");
    public static By basket                 = By.xpath("//span[@class='basket-title']");

    //BasketPage
    public static By priceTextInBasket      = By.xpath("//strong[@class='real-discounted-price']");
    public static By dropDownBox            = By.xpath("//select[@class='amount']");
    public static By deleteFromBasket       = By.xpath("//a[@class='btn-delete btn-update-item']");
    public static By productDeletedText     = By.xpath("//h2");

}
