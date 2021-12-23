package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By headerDropdown=By.cssSelector(".user");
    private By profileLink=By.xpath("//nav[@id='m-user']//a[.='Profile']");
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    //WebDriverWait wait = new WebDriverWait(driver, 5);
    //Actions actions = new Actions(driver);

    public CompanyPage getCompanyPage(){

//        wait.until(ExpectedConditions.presenceOfElementLocated(headerDropdown));
//    actions.moveToElement((WebElement) headerDropdown).moveToElement((WebElement) profileLink).click().perform();
        driver.get("https://wallethub.com/profile/13732055i");
        return new CompanyPage(driver);

    }
}
