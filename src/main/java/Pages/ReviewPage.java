package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ReviewPage {
    private WebDriver driver;
    private By dropdown= By.xpath("//span[.='Select...']");
    private By healthInsuranceOption=By.xpath("//*[@id=\"reviews-section\"]/modal-dialog/div/div/write-review/div/ng-" +
            "dropdown/div/ul/li[text()='Health Insurance']");
    private By textField=By.cssSelector(".wrev-user-input");
    private By submitButton= By.cssSelector(".sbn-action");
    private By continueButton=By.cssSelector(".rvc-continue-btn");

    public ReviewPage(WebDriver driver) {
        this.driver=driver;
    }

    //Write a review for the company
    public String reviewCompany(String review){
        driver.findElement(dropdown).click();
        driver.findElement(healthInsuranceOption).click();
        driver.findElement(textField).sendKeys(review);
        driver.findElement(submitButton).click();
        driver.findElement(continueButton).click();
        return driver.findElement(By.xpath("//*[contains(text(), "+review+")]")).getText();
    }

}
