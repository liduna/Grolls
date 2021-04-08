package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCreator {
    public WebDriver createBrowser(String browser){
        WebDriver driver = null;

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe" );
            driver = new ChromeDriver();
        }else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Selenium\\geckodriver.exe" );
            driver = new FirefoxDriver();
        }else if (browser.equals("edge")){
            System.setProperty("webdriver.edge.driver","C:\\Program Files\\Selenium\\msedgedriver.exe" );
            driver = new EdgeDriver();
        }
        return driver;


    }
}
