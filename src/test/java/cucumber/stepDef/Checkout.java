package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkout {
    WebDriver webdrv;
    String baseUrl= "https://www.saucedemo.com/";

//  positive case
    @Given("Logging in to application")
    public void user_logging_in(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt= new ChromeOptions();

        webdrv = new ChromeDriver(opt);
        webdrv.manage().window().maximize();
        webdrv.get(baseUrl);

        webdrv.findElement(By.id("user-name")).sendKeys("standard_user");
        webdrv.findElement(By.id("password")).sendKeys("secret_sauce");
        webdrv.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @When("user add product to cart")
    public void user_add_product(){
        webdrv.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }
    @And("user checkout product")
    public void user_checkout_product(){
        webdrv.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        webdrv.findElement(By.xpath("//button[@id='checkout']")).click();

    }
    @And("user fill (.*) as information$")
    public void user_fill_info(String information){
        if (information.equals("valid")){
            webdrv.findElement(By.id("first-name")).sendKeys("first");
            webdrv.findElement(By.id("last-name")).sendKeys("last");
            webdrv.findElement(By.id("postal-code")).sendKeys("12345");
        }else {
            webdrv.findElement(By.id("first-name")).sendKeys("first");
        }
    }
    @And("user finishing checkout (.*) as status$")
    public void user_finishing_checkout(String status) {
        if (status.equals("valid")) {
            webdrv.findElement(By.xpath("//input[@id='continue']")).click();
            webdrv.findElement(By.xpath("//button[@id='finish']")).click();
        } else {
            webdrv.findElement(By.xpath("//input[@id='continue']")).click();
        }
    }
    @Then("thank you should be displayed (.*) as status$")
    public void thank_you(String status){
        if (status.equals("valid")) {
            webdrv.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
        }else {
            webdrv.findElement(By.xpath("//h3[contains(text(),'Error')]"));
        }
        webdrv.quit();
    }
//  nagetive case
//@Given("Logging in to app")
//public void user_log_in(){
//    WebDriverManager.chromedriver().setup();
//    ChromeOptions opt= new ChromeOptions();
//
//    webdrv = new ChromeDriver(opt);
//    webdrv.manage().window().maximize();
//    webdrv.get(baseUrl);
//
//    webdrv.findElement(By.id("user-name")).sendKeys("standard_user");
//    webdrv.findElement(By.id("password")).sendKeys("secret_sauce");
//    webdrv.findElement(By.xpath("//input[@type='submit']")).click();
//}
//    @When("user add a product to cart")
//    public void user_add_a_product(){
//        webdrv.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
//    }
//    @And("user checkout a product")
//    public void user_checkout_a_product(){
//        webdrv.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
//        webdrv.findElement(By.xpath("//button[@id='checkout']")).click();
//
//    }
//    @And("user fill invalid information")
//    public void user_fill_invalid_info(){
//        webdrv.findElement(By.id("first-name")).sendKeys("first");
////        webdrv.findElement(By.id("last-name")).sendKeys("last");
//        webdrv.findElement(By.id("postal-code")).sendKeys("12345");
//    }
//    @And("user continue checkout")
//    public void user_continue_checkout(){
//        webdrv.findElement(By.xpath("//input[@id='continue']")).click();
////        webdrv.findElement(By.xpath("//button[@id='finish']")).click();
//    }
//    @Then("error message should be displayed")
//    public void error_message(){
//        webdrv.findElement(By.xpath("//h3[contains(text(),'Error')]"));
//        webdrv.quit();
//    }
}
