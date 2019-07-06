package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.FactoryWebDriver;

public class BasePage {

    private WebDriver webdriver;
    private static int TIMEOUT_IN_SECONDS = 10;

    protected BasePage() {
        this.webdriver = FactoryWebDriver.getWebDriver();
    }

    protected WebDriver getWebDriver(){
        return this.webdriver;
    }

    protected void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("return jQuery.active == 0");
    }

    protected void waitForElementToBeClickable(By element){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebDriverWait getWebDriverWait(){
        WebDriverWait wait = new WebDriverWait(this.getWebDriver(), TIMEOUT_IN_SECONDS);
        return wait;
    }

    protected void click(By element){
        getWebDriver().findElement(element).click();
    }

    protected void type(By element, String text){
        WebElement field = getWebDriver().findElement(element);
        field.clear();
        field.sendKeys(text);
    }
}
