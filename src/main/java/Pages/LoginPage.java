package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField= By.id("email");
    private By passwordField= By.id("password");
    private By loginButton= By.cssSelector(".blue");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String email,String password){
        //Enter login credentials
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);

        //Click the login button
        driver.findElement(loginButton).click();

        return new HomePage(driver);
    }
}
