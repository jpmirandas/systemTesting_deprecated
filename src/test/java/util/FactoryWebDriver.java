package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FactoryWebDriver {

    static WebDriver webdriver;

    public static WebDriver getWebDriver() {

        if (webdriver == null) {

            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

//            ChromeOptions options = new ChromeOptions();
//					options.addArguments("headless");
//					options.addArguments("window-size=1200x600");
//					webdriver = new ChromeDriver(options);
            webdriver = new ChromeDriver();
        }

        return webdriver;
    }
}