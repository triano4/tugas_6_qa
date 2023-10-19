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
import java.time.Duration;

public class Login {
    WebDriver driver;
    String baseUrl= "https://www.saucedemo.com/";

//  Positive test
    @Given("Login to application")
    public void user_is_on_login_page(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt= new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input (.*) as username$")
    public void user_input_username(String username){
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @And("user input (.*) as password$")
    public void user_input_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @And("user click submit")
    public void user_input_submit(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @Then("Homepage / error should be displayed (.*) as status$")
    public void homepage_success(String status){
        if(status.equals("success")) {
            driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        }else {
            driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]"));
        }
        driver.quit();
    }
}
