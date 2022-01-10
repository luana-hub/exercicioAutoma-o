package page.sauceDemo;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(id = "finish")
    private WebElement buttonFinish;

    public void setButtonFinish() throws Exception {
        dsl.clicarBotao(buttonFinish);
    }
}
