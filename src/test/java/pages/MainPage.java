package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement queueList = $("#id_queue");
    private final SelenideElement queueValueDjangoHelpDesk = $x("//option[text() ='Django Helpdesk']");
    private final SelenideElement issueSummaryInput = $("#id_title");
    private final SelenideElement issueDescriptionInput = $("#id_body");
    private final SelenideElement priorityList = $("#id_priority");
    private final SelenideElement priorityListCriticalValue = $x("(//option[@value='1'])[2]");
    private final SelenideElement dueOnDate = $("#id_due_date");
    private final SelenideElement dueOnDateValue = $x("//table[@class = 'ui-datepicker-calendar']//a[text() = '12']");
    private final SelenideElement emailAdressField = $("#id_submitter_email");
    private final SelenideElement submitButton = $x("//button[@type= 'submit']");
    private final SelenideElement logInButton = $("#userDropdown");

    @Step("Заполнить тикет данными")
    public MainPage createNewTicket(String title, String body, String email){
        queueList.click();
        queueValueDjangoHelpDesk.click();
        issueSummaryInput.sendKeys(title);
        issueDescriptionInput.sendKeys(body);
        priorityList.click();
        priorityListCriticalValue.click();
        dueOnDate.click();
        dueOnDateValue.click();
        emailAdressField.sendKeys(email);
        submitButton.click();
        return this;
    }
    @Step("Нажать на кнопку авторизации")
    public LoginPage authorization(){
        logInButton.click();
        return new LoginPage();
    }
}
