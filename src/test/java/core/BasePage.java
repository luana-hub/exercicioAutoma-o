package core;

import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected DSL dsl;

    public BasePage() {
        dsl = new DSL();
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

}
