package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import waiter.Waiter;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    private Waiter waiter;

    @Given("I navigated to a webpage https:\\/\\/www.grolls.se\\/helags-t-shirt--svart1100099.html")
    public void iNavigatedToAWebpageHttpsWwwGrollsSeHelagsTShirtSvartHtml() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https:\\/www.grolls.se\\/helags-t-shirt--svart1100099.html");
        Thread.sleep(4000);

    }
    @When("I select the amount of products in drop-down menu")
    public void iSelectTheAmountOfProductsInDropdowmMenu() throws InterruptedException {
        Select dropSizeMenu = new Select(driver.findElement(By.xpath(" //select[@id='attribute400']")));
        dropSizeMenu.selectByValue("1424");
        Thread.sleep(2000);
    }

   @And("I select the amount of the products")
    public void iSelectTheAmountOfTheProducts() throws InterruptedException {
        WebElement plusNumberOfItem = driver.findElement(By.className("qty-plus"));
        plusNumberOfItem.click();
       Thread.sleep(1000);

    }

    @And("I press add to cart button")
    public void iPressButton() throws InterruptedException {
        WebElement addInCartButton = driver.findElement(By.xpath
                ("//button[@id='product-addtocart-button']//span[contains(text(),'Lägg i varukorgen')]"));
        addInCartButton.click();
        Thread.sleep(2000);
    }


    @Then("I am able to  add the item to cart")
    public void iAmAbleToAddTheItemToCart() {

        WebElement numOfItemsInCart = driver.findElement(By.xpath
                ("//span[@class='counter-number'][normalize-space()='2']"));
        assertEquals("2", numOfItemsInCart.getText());

    }



}
