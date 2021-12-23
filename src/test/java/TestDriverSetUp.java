import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestDriverSetUp {
    private WebDriver driver;
    private String browser;
    private String baseUrl;



    public TestDriverSetUp(String browser, String baseUrl)  {
        this.browser = browser;
        this.baseUrl = baseUrl;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver=new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        }

        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(baseUrl);
    }


    public WebDriver getDriver() {
        return this.driver;
    }
}


