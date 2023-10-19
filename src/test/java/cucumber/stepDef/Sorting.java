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

public class Sorting {
    WebDriver webdrv;
    String baseUrl= "https://www.saucedemo.com/";

    @Given("Login web")
    public void user_login(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt= new ChromeOptions();

        webdrv = new ChromeDriver(opt);
        webdrv.manage().window().maximize();
        webdrv.get(baseUrl);

        webdrv.findElement(By.id("user-name")).sendKeys("standard_user");
        webdrv.findElement(By.id("password")).sendKeys("secret_sauce");
        webdrv.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @When("click sorting button")
    public void user_add_product(){
        webdrv.findElement(By.xpath("//select[@class='product_sort_container']")).click();
    }
    @And("select sorting type")
    public void user_checkout_product(){
        webdrv.findElement(By.xpath("//option[@value='lohi']")).click();
    }
    @Then("show sort result")
    public void thank_you(){
        webdrv.findElement(By.xpath("//option[@value='lohi']")).isSelected();
        webdrv.quit();
    }

}
