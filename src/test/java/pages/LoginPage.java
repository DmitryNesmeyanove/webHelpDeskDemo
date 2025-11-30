package pages;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final SelenideElement userName = $("#username");
    private final SelenideElement passwordLog = $("#password");
    private final SelenideElement loginButton = $x("//input[@type = 'submit']");

    @Step("Ввести логин и пароль для авторизации в систему")
    public TicketPage logInToTheSystem(String login, String password){
        userName.sendKeys(login);
        passwordLog.sendKeys(password);
        loginButton.click();
        return new TicketPage();
    }
}
