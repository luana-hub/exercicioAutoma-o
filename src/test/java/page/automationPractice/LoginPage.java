package page.automationPractice;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = ".//*[@id='email']")
    private WebElement campoEmail;

    @FindBy(xpath = ".//*[@id='passwd']")
    private WebElement campoSenha;

    @FindBy(xpath = ".//*[@id='SubmitLogin']")
    private WebElement botaoLogin;

    @FindBy(xpath = ".//*[@class='icon-chevron-left']")
    private WebElement botaoHome;

    public void setCampoEmail(String email) {
        dsl.escrever(campoEmail, email);
    }

    public void setCampoSenha(String senha) {
        dsl.escrever(campoSenha, senha);
    }

    public void setBotaoLogin() throws Exception {
        dsl.clicarBotao(botaoLogin);
    }

    public void setLogoHomePage() throws Exception {
        dsl.clicarBotao(botaoHome);
    }
}
