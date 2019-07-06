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

    protected void waitForElementToBeClickable(By locator){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToBeDisplayed(By locator){
        WebElement element = getWebDriver().findElement(locator);
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebDriverWait getWebDriverWait(){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), TIMEOUT_IN_SECONDS);
        return wait;
    }

    protected void click(By locator){
        getWebDriver().findElement(locator).click();
    }

    protected void type(By locator, String text){
        WebElement field = getWebDriver().findElement(locator);
        field.clear();
        field.sendKeys(text);
    }

    protected void closeWindow(){
        getWebDriver().quit();
    }

    // TODO
    protected boolean isElementDisplayed(By locator){
        return true;
    }
}
