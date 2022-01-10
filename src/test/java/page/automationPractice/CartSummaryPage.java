package page.automationPractice;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSummaryPage extends BasePage {

    @FindBy(xpath = ".//*[@id='total_price']")
    private WebElement valorTotal;

    public String getValorTotal() {
        return dsl.obterTexto(valorTotal);
    }
}
