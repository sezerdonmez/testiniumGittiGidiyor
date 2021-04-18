package testinium.scenario.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testinium.scenario.main.MainClass;

import static testinium.scenario.elements.Elements.*;

public class LoginPage extends MainClass {

    public LoginPage(WebDriver wDriver){

        this.driver = wDriver;

    }

    public void enterIdPass(){

        WebElement enterEMail = driver.findElement(usernameInput);
        enterEMail.sendKeys(eMail);
        WebElement enterPassword = driver.findElement(passwordInput);
        enterPassword.sendKeys(password);
        wait(1);

    }

    public void pressLogin(){

        WebElement loginPageButton = driver.findElement(loginButton);
        loginPageButton.click();

    }
}
