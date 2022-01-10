package page.sauceDemo;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = ".//*[@id='user-name']")
    private WebElement campoUserName;

    @FindBy(xpath = ".//*[@id='password']")
    private WebElement campoPassword;

    @FindBy(xpath = ".//*[@id='login-button']")
    private WebElement botaoLogin;

    @FindBy(xpath = ".//*[@data-test='error']")
    private WebElement textoErroLogin;

    public void setLogin(String usuario,String senha) throws Exception {
        dsl.escrever(campoUserName, usuario);
        dsl.escrever(campoPassword, senha);
        dsl.clicarBotao(botaoLogin);
    }

    public String getTextoErroLogin() {
        return dsl.obterTexto(textoErroLogin);
    }
}
