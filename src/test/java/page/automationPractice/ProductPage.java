package page.automationPractice;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = ".//*[@type='submit' and @ class='exclusive']")
    private WebElement botaoAddCart;

    @FindBy(xpath = ".//*[@title='Proceed to checkout']")
    private WebElement botaoProceedToCheckout;

    public void setBotaoAddCart() throws Exception {
        dsl.clicarBotao(botaoAddCart);
    }

    public void setBotaoProceedToCheckout() throws Exception {
        dsl.clicarBotao(botaoProceedToCheckout);
    }

}
