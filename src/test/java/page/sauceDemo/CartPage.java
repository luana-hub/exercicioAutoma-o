package page.sauceDemo;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement buttonCheckout;

    @FindBy(className = "inventory_item_name")
    private WebElement itemCart;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement buttonRemove;

    @FindAll(
            @FindBy(xpath = ".//*[@class='btn btn_secondary btn_small cart_button']")
    )
    private List<WebElement> products;

    public void setButtonCheckout() throws Exception {
        dsl.clicarBotao(buttonCheckout);
    }

    public String getItemCart() {
        return dsl.obterTexto(itemCart);
    }

    public void setButtonRemove(Integer product) throws Exception {
        dsl.clicarBotao(products.get(product));
    }

    public Boolean validaCarrinhoVazio() {
        Boolean vazio = false;
        if (products.isEmpty()) {
            vazio = true;
        }
        return vazio;
    }

    public Boolean validaProdutosCarrinho() {
        Boolean produtos = false;
        if (products.size() == 6) {
            produtos = true;
        }
        return produtos;
    }
}
