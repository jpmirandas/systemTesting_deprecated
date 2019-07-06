import org.openqa.selenium.WebDriver;
import util.FactoryWebDriver;

public class Runner {

    public static void main(String[] args){
        WebDriver driver = FactoryWebDriver.getWebDriver();
        driver.get("https://www.google.com.br");
    }
}
