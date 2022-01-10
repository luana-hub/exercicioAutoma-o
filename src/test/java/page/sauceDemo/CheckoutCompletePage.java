package page.sauceDemo;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(xpath = ".//*[@class='complete-header']")
    private WebElement messageComplete;

    public String getTitleFinish() {
        return dsl.obterTexto(messageComplete);
    }
}
