package page.sauceDemo;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//*[@class='title']")
    private WebElement logoProduct;

    @FindBy(xpath = ".//*[@class='shopping_cart_link']")
    private WebElement shoppingCartEmpty;

    @FindBy(xpath = ".//*[@class='shopping_cart_badge']")
    private WebElement shoppingCart;

    @FindBy(xpath = ".//*[@class='product_sort_container']")
    private WebElement comboFilter;

    @FindAll(
            @FindBy(xpath = ".//*[@class='btn btn_primary btn_small btn_inventory']")
    )
    private List<WebElement> products;

    @FindAll(
            @FindBy(xpath = ".//*[@class='inventory_item_price']"))
    private List<WebElement> price;

    @FindAll(
            @FindBy(xpath = ".//*[@class='inventory_item_name']"))
    private List<WebElement> productNames;

    @FindBy(xpath = ".//*[@class='btn btn_secondary btn_small btn_inventory']")
    private WebElement buttonRemove;

    public String getProductLogo() {
        return dsl.obterTexto(logoProduct);
    }

    public void setProduct(Integer product) throws Exception {
        dsl.clicarBotao(products.get(product));
    }

    public void setShoppingCart() throws Exception {
        dsl.clicarBotao(shoppingCartEmpty);
    }

    public void setComboFilter() {
        dsl.transformaCombo(comboFilter, 2);
    }

    public List<String> allPrice() {
        List<String> listaValores = new ArrayList<String>();
        price.forEach(p ->
                listaValores.add(p.getText())
        );
        return listaValores;
    }

    public List<String> allName() {
        List<String> listName = new ArrayList<String>();
        productNames.forEach(p ->
                listName.add(p.getText())
        );
        return listName;
    }

    public void addAllProductsCart() {
        products.forEach(WebElement::click
        );
    }

    public void setButtonRemove() throws Exception {
        if (shoppingCartEmpty.isDisplayed()) {
            dsl.clicarBotao(buttonRemove);
        }
    }
}
