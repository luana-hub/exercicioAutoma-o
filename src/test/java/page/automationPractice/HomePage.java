package page.automationPractice;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//*[@class='login']")
    private WebElement botaoSignIn;

    @FindBy(linkText = "Faded Short Sleeve T-shirts")
    private WebElement productFadedShort;

    @FindBy(linkText = "Blouse")
    private WebElement productBlouse;


    public void setBotaoSignIn() throws Exception {
        dsl.clicarBotao(botaoSignIn);
    }

    public void setProduct(String produto) throws Exception {
        dsl.clicarBotao(escolherProduto(produto));
    }

    public WebElement escolherProduto(String produto) throws InterruptedException {
        WebElement element;
        if (Objects.equals(produto, "camisa")) {
            element = productFadedShort;
        }else {
            element = productBlouse;
        }
        return element;
    }
}
