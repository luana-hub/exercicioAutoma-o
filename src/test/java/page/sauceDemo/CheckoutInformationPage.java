package page.sauceDemo;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement campoFirstName;

    @FindBy(id = "last-name")
    private WebElement campoLastName;

    @FindBy(id = "postal-code")
    private WebElement campoPostalCode;

    @FindBy(xpath = ".//*[@id='continue']")
    private WebElement buttonContinue;

    public void preencheCampos(String nome,String sobrenome,String cep) throws Exception {
        campoFirstName.sendKeys(nome);
        campoLastName.sendKeys(sobrenome);
        campoPostalCode.sendKeys(cep);
        dsl.clicarBotao(buttonContinue);

    }
}
