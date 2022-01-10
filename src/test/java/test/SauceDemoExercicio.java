package test;

import core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.sauceDemo.*;

public class SauceDemoExercicio {

    private String senha = "secret_sauce";
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    private final CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    private final CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @After
    public void fechaNavegador() {
        DriverFactory.closeDriver();
    }

    @Test
    public void ex1ValidaLogin() throws Exception {
        loginPage.setLogin("standard_user", senha);
        Assert.assertEquals("PRODUCTS", homePage.getProductLogo());

    }

    @Test
    public void ex2ValidaCarrinho() throws Exception {
        loginPage.setLogin("standard_user", senha);
        homePage.setProduct(0);
        homePage.setShoppingCart();
        Assert.assertEquals("Sauce Labs Backpack", cartPage.getItemCart());

    }

    @Test
    public void ex3ValidaFiltro() throws Exception {
        loginPage.setLogin("standard_user", senha);
        homePage.setComboFilter();
        Assert.assertEquals("$7.99", homePage.allPrice().get(0));
    }

    @Test
    public void ex4ValidaExclusaoCarrinho() throws Exception {
        loginPage.setLogin("standard_user", senha);
        homePage.setProduct(2);
        homePage.setShoppingCart();
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", cartPage.getItemCart());
        cartPage.setButtonRemove(0);
        Assert.assertTrue(cartPage.validaCarrinhoVazio());
    }

    @Test
    public void ex5ValidaAddTodosItens() throws Exception {
        loginPage.setLogin("standard_user", senha);
        homePage.addAllProductsCart();
        homePage.setShoppingCart();
        Assert.assertTrue(cartPage.validaProdutosCarrinho());
    }

    @Test
    public void ex6ValidaAddCarrinho() throws Exception {
        loginPage.setLogin("standard_user", senha);
        homePage.setProduct(0);
        homePage.setButtonRemove();
    }

    @Test
    public void ex7ValidaProdutoNaHome() throws Exception {
        loginPage.setLogin("standard_user", senha);
        Assert.assertEquals("Sauce Labs Backpack", homePage.allName().get(0));
    }

    @Test
    public void ex8ValidaErroLogin() throws Exception {
        loginPage.setLogin("locked_out_user", senha);
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getTextoErroLogin());
    }

    @Test
    public void ex9ValidaCheckout() throws Exception {
        loginPage.setLogin("standard_user", senha);
        homePage.setProduct(0);
        homePage.setShoppingCart();
        cartPage.setButtonCheckout();
        checkoutInformationPage.preencheCampos("Guilherme","Porto Malta","04707061");
        checkoutOverviewPage.setButtonFinish();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER",checkoutCompletePage.getTitleFinish());

    }

}
