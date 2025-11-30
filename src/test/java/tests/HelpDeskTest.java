package tests;


import base.BasePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;


@Epic("Заполнение тикета на форме HelpDesk")
public class HelpDeskTest extends BasePage {
    private static final String title = "При загрузке странице появляется 404 ошибка";
    private static final String body = "При загрузке странице появляется 404 ошибка - которая указывает - что страницы не существует";
    private static final String email = "test.testu@test.com";
    @Test
    @Story("Успешное заполнение тикета")
    @DisplayName("Ввод валидных данных")
    @Owner("Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("""
            1. Зайти на страницу и заполнить форму валидными данными.
            2. Авторизоваться на сайте.
            3. Перейти в раздел с тикетом и сверить заполненные данные.""")
    public void checkHelpDeskTicket(){
        MainPage mainPage = new MainPage();
        mainPage.createNewTicket(title, body, email)
                .authorization()
                .logInToTheSystem("admin","adminat")
                .search(email)
                .ticket()
                .verifyEmailAndDescription(title,email,body);
    }
}
