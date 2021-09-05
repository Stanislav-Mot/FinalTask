package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import logs.Log;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public static String getURL() {
        return URL;
    }

    private static final String URL = "https://opensource-demo.orangehrmlive.com/";

    private final SelenideElement loginField = $x("//input[@name='txtUsername']");
    private final SelenideElement passwordField = $x("//input[@name='txtPassword']");
    private final SelenideElement loginButton = $x("//input[@id='btnLogin']");

    @Step("Open page")
    public void openPage() {
        Log.info("Open main page");
        open(URL);
    }

    @Step("Enter login")
    public LoginPage enterLogin(String login) {
        try {
            Log.info("Enter login");
            loginField.sendKeys(properties.PropertyUser.getPropertyValue(login));
        } catch (Exception e) {
            Log.error(e);
        }
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        try {
            Log.info("Enter password");
            passwordField.sendKeys(properties.PropertyUser.getPropertyValue(password));
        } catch (Exception e) {
            Log.error(e);
        }
        return this;
    }

    @Step("Click login button")
    public void clickLoginButton() {
        Log.info("Click login button");
        loginButton.click();
    }

    public void loginToTheSite(String login, String password) {
        enterLogin(login).enterPassword(password).clickLoginButton();
    }
}
