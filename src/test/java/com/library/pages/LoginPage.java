package com.library.pages;

import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "inputEmail")
    public WebElement usernameBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginBtn;

    public void login(){

        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
        String username = ConfigurationReader.getProperty("librarian_username");
        String password = ConfigurationReader.getProperty("password");

        //BrowserUtils.waitFor(3);
        usernameBox.sendKeys(username);
        //BrowserUtils.waitFor(3);
        passwordBox.sendKeys(password);
        //BrowserUtils.waitFor(3);
        loginBtn.click();

    }

}
