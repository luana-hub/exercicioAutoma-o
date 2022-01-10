package steps;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.automationPractice.CartSummaryPage;
import page.automationPractice.HomePage;
import page.automationPractice.LoginPage;
import page.automationPractice.ProductPage;

public class ShoppingCartSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartSummaryPage cartPage;

    @Before
    public void inicializa() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php");
        homePage = new HomePage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartSummaryPage();
    }

    @After
    public void fechaNavegador() {
        DriverFactory.closeDriver();
    }

    @Given("que acesso o site Automation practice")
    public void queAcessoOSiteAutomationPractice() throws Exception {
        homePage.setBotaoSignIn();
        loginPage.setCampoEmail("email@email.email ");
        loginPage.setCampoSenha("tester123");
        loginPage.setBotaoLogin();
        loginPage.setLogoHomePage();
    }

    @When("seleciono o produto {string} na tela inicial e vou para o carrinho de compras")
    public void selecionoOProdutoProdutoNaTelaInicialEVouParaOCarrinhoDeCompras(String produto) throws Exception {
        homePage.setProduct(produto);
        productPage.setBotaoAddCart();
        productPage.setBotaoProceedToCheckout();
    }

    @Then("o site exibe o valor do meu produto {string} do meu carrinho de compras")
    public void oSiteExibeOValorTotalDoMeuCarrinhoDeCompras(String valor) throws InterruptedException {
        Assert.assertEquals(valor, cartPage.getValorTotal());
    }

}
