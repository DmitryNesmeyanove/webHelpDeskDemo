package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TicketPage {
    private final SelenideElement searchWeb = $("#search_query");
    private final SelenideElement ticketOpenFirstElement = $x("//div[@class = 'tickettitle'][1]");
    private final SelenideElement emailValue = $x("//th[text() ='Submitter E-Mail']/following::td[1]");
    private final SelenideElement descriptionValue = $x("//td[@id='ticket-description']");
    private final SelenideElement mainTitle = $x("//thead[@class = 'thead-light']");

    @Step("Ввести в поисковую строку данные и произвести клик")
    public TicketPage search(String searchElement){
        searchWeb.sendKeys(searchElement, Keys.ENTER);
        return new TicketPage();
    }
    @Step("Произвести клик по найденному тикету")
    public TicketPage ticket(){
        ticketOpenFirstElement.click();
        return this;
    }
    @Step("Произвести сравнение ОР и ФР заполненного тикета")
    public TicketPage verifyEmailAndDescription(String titleValue, String expectedEmail, String expectedBody) {
        mainTitle.shouldHave(partialText(titleValue));
        emailValue.shouldHave(partialText(expectedEmail));
        descriptionValue.shouldHave(partialText(expectedBody));
        return this;
    }
}
