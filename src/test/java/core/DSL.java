package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static core.DriverFactory.getDriver;

public class DSL {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    public final String screenshotTime = getDatetime();

    public void escrever(WebElement element, String texto) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(texto);
    }

    public void clicarBotao(WebElement element) throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highLighterMethod(element);
        scrollToElement(element);
        takeScreenshot(getDatetime().toString());
        element.click();
    }

    public String obterTexto(WebElement element) {
        highLighterMethod(element);
        takeScreenshot(getDatetime());
        return element.getText();
    }

    public void takeScreenshot(String fileName) {
        try {
            File screenshotFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            String folderName = "Evidencias";
            FileUtils.copyFile(screenshotFile, new File("src/main/resources/" + folderName + "/" + screenshotTime
                    + "/" + fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDatetime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD_hh-mm-ss", Locale.getDefault());
        return dateFormat.format(date);
    }

    public void highLighterMethod(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 6px solid red;');", element);
    }

    private void scrollToElement(WebElement webElement) throws Exception {
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoViewIfNeeded()", webElement);
    }

    public void transformaCombo(WebElement webElement, Integer value) {
        Select select = new Select(webElement);
        select.selectByIndex(value);
    }

}
