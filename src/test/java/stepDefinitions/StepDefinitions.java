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

    @Given("I navigated  a webpage https:\\/\\/www.grolls.se\\/helags-t-shirt--svart1100099.html")
    public void iNavigatedAWebpageHttpsWwwGrollsSeHelagsTShirtSvartHtml() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https:\\/www.grolls.se\\/helags-t-shirt--svart1100099.html");
        Thread.sleep(4000);

    }


    @When("I select the size of a product in drop-down menu")
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




    @When("I select two same items of same size")
    public void iSelectTwoSameItemsOfSameSize() throws InterruptedException {
        Select dropSizeMenu = new Select(driver.findElement(By.xpath(" //select[@id='attribute400']")));
        dropSizeMenu.selectByValue("1424");
        Thread.sleep(2000);
        WebElement plusNumberOfItem = driver.findElement(By.className("qty-plus"));
        plusNumberOfItem.click();
        Thread.sleep(1000);

    }


    @And("I add them into cart")
    public void iAddThemIntoCart() throws InterruptedException {
        WebElement addInCartButton = driver.findElement(By.xpath
                ("//button[@id='product-addtocart-button']//span[contains(text(),'Lägg i varukorgen')]"));
        addInCartButton.click();
        Thread.sleep(2000);

        
    }

    @And("I click on cart icon")
    public void iClickOnCartIcon() throws InterruptedException {
        WebElement cartIcon = driver.findElement(By.xpath
                ("//a[@class='action showcart']//icon[@class='icon-shopping-cart-white minicart-icon']//*[local-name()='svg']"));
        cartIcon.click();
        Thread.sleep(2000);


    }

    @Then("I am able to see previously selected items added into cart")
    public void iAmAbleToSeeTwoItemsAddedIntoCart() {
        WebElement productName = driver.findElement(By.xpath
                (" //a[@data-bind='attr: {href: product_url}, text: product_name']"));
        assertEquals("HELAGS T-SHIRT SVART", productName.getText());

    }

    @And("I have two of these items in the cart")
    public void iHaveTwoOfTheseItemsInTheCart() {
        WebElement productQty = driver.findElement(By.xpath
                ("/html/body/div[4]/header/div[3]/div[4]/div/div/div/div[2]/div[4]/div/ol/li/div/div/div[3]/div[2]/input"));


       assertEquals("2", productQty.getAttribute("value"));
    }


    @When("I select the size of an item")
    public void iSelectTheSizeOfAnItem() throws InterruptedException {
        Select dropSizeMenu = new Select(driver.findElement(By.xpath(" //select[@id='attribute400']")));
        dropSizeMenu.selectByValue("1424");
        Thread.sleep(2000);
    }


    @Then("I can increase its number in the quantity input field")
    public void iCanIncreaseItsNumberInTheQuantityInputField() throws InterruptedException {
        WebElement qtyInput = driver.findElement(By.xpath
                        ("/html/body/div[4]/main/div[2]/div/div[1]/div[2]/div[5]/form/div[2]/div/div/div[1]/div/div/input[2]"));
        qtyInput.clear();
        qtyInput.sendKeys("2");
        Thread.sleep(2000);




    }

    @And("I can add selected number of items into cart")
    public void iCanAddSelectedNumberOfItemsIntoCart() throws InterruptedException {
        WebElement addInCartButton = driver.findElement(By.xpath
                ("//button[@id='product-addtocart-button']//span[contains(text(),'Lägg i varukorgen')]"));
        addInCartButton.click();
        Thread.sleep(2000);

        WebElement productQty = driver.findElement(By.xpath
                ("/html/body/div[4]/header/div[3]/div[4]/div/div/div/div[2]/div[4]/div/ol/li/div/div/div[3]/div[2]/input"));


        assertEquals("2", productQty.getAttribute("value"));




    }
}

