import Configuration.ConfigurationFileReader;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    ConfigurationFileReader fileReader=new ConfigurationFileReader();
    private WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    private final String baseUrl = "https://wallethub.com/join/login";
    private String username=fileReader.getUserName();
    private String password=fileReader.getPassword();




    //This sets up an optional configuration to run the test(s) within the class
    @BeforeTest
    @Parameters({"browser", "url"})
    public void setup(@Optional("chrome")String browser, @Optional(baseUrl)String url){
        TestDriverSetUp testDriverSetUp = new TestDriverSetUp(browser, url);
        driver = testDriverSetUp.getDriver();
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        loginToWallethub();
    }



    public void loginToWallethub(){
        loginPage= new LoginPage(driver);
        loginPage.login(username,password);
        homePage=new HomePage(driver);
    }



    @AfterTest
    public void endSession() {
        driver.quit();
    }

}



