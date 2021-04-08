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
import org.openqa.selenium.support.ui.WebDriverWait;
import waiter.Waiter;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    private Waiter waiter;


    private void waitUntil(WebDriver driver, By by){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    private void sendKeys(WebDriver driver, By by, String keys){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
        System.out.println("Sending Keys");


    }

   //@addingItems

    @Given("I navigated  a webpage grolls")
    public void iNavigatedAWebpageHttpsWwwGrollsSeHelagsTShirtSvartHtml()  {
        /*System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https:\\/www.grolls.se\\/helags-t-shirt--svart1100099.html");*/

        DriverCreator creator = new DriverCreator();
        driver = creator.createBrowser("edge");
        driver.get("https:\\/www.grolls.se\\/helags-t-shirt--svart1100099.html");
        driver.manage().window().maximize();

        /*driver = creator.createBrowser("firefox");
        driver.get("https:\\/www.grolls.se\\/helags-t-shirt--svart1100099.html");
        driver.manage().window().maximize();*/


    }


    @When("I select the size of a product in drop-down menu")
    public void iSelectTheAmountOfProductsInDropdowmMenu()  {
        /*waitUntil(driver,By.xpath("select[name=super_attribute[400]") );
        waitUntil(driver, By.cssSelector("option[value='1424']" ));//[style='display:block']"));*/
        Select dropSizeMenu = new Select(driver.findElement(By.xpath(" //select[@id='attribute400']")));
        dropSizeMenu.selectByValue("1424");

    }

   @And("I select the amount of the products")
    public void iSelectTheAmountOfTheProducts() {
        waitUntil(driver, By.cssSelector(".qty-plus"));

       /* WebElement plusNumberOfItem = driver.findElement(By.className("qty-plus"));
        plusNumberOfItem.click();*/
    }

    @And("I press add to cart button")
    public void iPressButton() {
        waitUntil(driver, By.cssSelector("button[class='action primary tocart']"));
       /* WebElement addInCartButton = driver.findElement(By.xpath
                ("//button[@id='product-addtocart-button']//span[contains(text(),'Lägg i varukorgen')]"));
        addInCartButton.click();*/

    }


    @Then("I am able to  see two items in the cart")
    public void iAmAbleToAddTheItemToCart() {
        waitUntil(driver, By.xpath("/html/body/div[4]/header/div[3]/div[4]/a/span/span[1]"));

        //WebElement numOfItemsInCart = driver.findElement(By.className("counter-number"));

        WebElement numOfItemsInCart = driver.findElement(By.xpath("/html/body/div[4]/header/div[3]/div[4]/a/span/span[1]"));
        //System.out.println(numOfItemsInCart.getText());[class='minicart-wrapper']
               // ("//span[@class='counter-number'][normalize-space()='2']"));
       assertEquals("3", numOfItemsInCart.getText());
       driver.close();

    }

        // @Controlling items in the cart


    @When("I select two same items of same size")
    public void iSelectTwoSameItemsOfSameSize() throws InterruptedException {
        Select dropSizeMenu = new Select(driver.findElement(By.cssSelector("#attribute400")));
      // Thread.sleep(5000);
        dropSizeMenu.selectByVisibleText("M - 1100099-M");
       Thread.sleep(5000);
        WebElement plusNumberOfItem = driver.findElement(By.xpath("//img[@data-action='addQty']"));
        plusNumberOfItem.click();


    }


    @And("I add them into cart")
    public void iAddThemIntoCart() throws InterruptedException {
        WebElement addInCartButton = driver.findElement(By.cssSelector("#product-addtocart-button"));
        addInCartButton.click();
        //waitUntil(driver,By.cssSelector("#product-addtocart-button"));
        Thread.sleep(2000);


        
    }

      @And("I click on cart icon")
      public void iClickOnCartIcon() throws InterruptedException {

          WebElement cartIcon = driver.findElement(By.cssSelector("div[class='minicart-wrapper'] [class='counter-number']"));
          //waitUntil(driver, By.xpath("/html/body/div[4]/header/div[3]/div[4]"));
          cartIcon.click();
         // Thread.sleep(3000);

      }

    @Then("I am able to see previously selected items added into cart")
    public void iAmAbleToSeeTwoItemsAddedIntoCart() {
        WebElement productName = driver.findElement(By.xpath
                ("//*[@id=\"mini-cart\"]/li/div/div/strong/a"));//"div[class='ajax_enabled'] [style='display:block']"
        //waitUntil(driver, By.xpath("//*[@id=\"mini-cart\"]/li/div/div/strong/a"));
        assertEquals("HELAGS T-SHIRT SVART", productName.getText());
        System.out.print(productName.getText());


    }

    @And("I have two of these items in the cart")
    public void iHaveTwoOfTheseItemsInTheCart() {
        WebElement productQtyInCart = driver.findElement(By.xpath
               ("/html/body/div[4]/header/div[3]/div[4]/div/div/div/div[2]/div[4]/div/ol/li/div/div/div[3]/div[2]/input"));

        assertEquals("2", productQtyInCart.getAttribute("value"));
        System.out.print("  " + productQtyInCart.getLocation());
        driver.close();

    }
    /*private void waitUntil(WebDriver driver, By by){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }*/

    //@adding via numlock

    @When("I select the size of an item")
    public void iSelectTheSizeOfAnItem() {
        Select dropSizeMenu = new Select(driver.findElement(By.xpath(" //select[@id='attribute400']")));
        dropSizeMenu.selectByValue("1424");
    }


    @Then("I can increase its number in the quantity input field")
    public void iCanIncreaseItsNumberInTheQuantityInputField()  {
        WebElement qtyInput = driver.findElement(By.xpath
                        ("/html/body/div[4]/main/div[2]/div/div[1]/div[2]/div[5]/form/div[2]/div/div/div[1]/div/div/input[2]"));
        qtyInput.clear();
        qtyInput.sendKeys("2");

    }

    @And("I can add selected number of items into cart")
    public void iCanAddSelectedNumberOfItemsIntoCart() {
        WebElement addInCartButton = driver.findElement(By.xpath
                ("//button[@id='product-addtocart-button']//span[contains(text(),'Lägg i varukorgen')]"));
        addInCartButton.click();


        WebElement productQty = driver.findElement(By.xpath
                ("/html/body/div[4]/header/div[3]/div[4]/div/div/div/div[2]/div[4]/div/ol/li/div/div/div[3]/div[2]/input"));


        assertEquals("2", productQty.getAttribute("value"));
        driver.close();



    }
}

