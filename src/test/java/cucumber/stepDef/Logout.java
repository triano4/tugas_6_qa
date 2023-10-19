package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Logout {
    WebDriver webdrv;
    String baseUrl= "https://www.saucedemo.com/";

    @Given("Login")
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
    @When("click burger button")
    public void user_add_product(){
        webdrv.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }
    @And("click logout")
    public void user_checkout_product(){
        webdrv.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webdrv.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }
    @Then("back to homepage")
    public void thank_you(){
        webdrv.findElement(By.id("login-button")).isDisplayed();
        webdrv.quit();
    }
}
