package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CompanyPage {
    public CompanyPage(WebDriver driver) {
        this.driver=driver;
    }
    private WebDriver driver;
    private By reviewsTab=By.xpath("//span[.='3.2k']");
    private int i=1;
    private String star=".review-action svg:nth-of-type("+i+") [d='M6.37 32l3.972-12.215-10.417-7.569h12.89l3.972-12.215 3.972 " +
            "12.215h12.89l-10.417 7.569 3.972 12.215-10.417-7.569zM16.787 22.557l7" +
            ".569 5.471-2.848-8.843 7.569-5.471h-9.368l-2.848-8.843-2.848 8.843h-9.368l7.569 5.471-2.848 8.843z']";


    public void scrollToTheStars(){
        //Switch to the "Reviews" tab
        driver.findElement(reviewsTab).click();
        //Scroll to the review stars section
        String scrollAction= "window.scrollBy(0,150)";
        ((JavascriptExecutor)driver).executeScript(scrollAction,"");
    }

        public List<String> verifyStarColour(){
            scrollToTheStars();
            List<String> starFillColour= new ArrayList<>();
            for(int i=1;i<=5;i++){
                WebDriverWait wait=new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(star)));
                Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.cssSelector(star))).build().perform();
                starFillColour.add(driver.findElement(By.cssSelector(star)).getAttribute("fill"));
            }
            return starFillColour;

        }

        public ReviewPage rateCompany(int rating){
            scrollToTheStars();
            WebDriverWait wait=new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".review-action svg:nth-of-type("+rating+")")));
            driver.findElement(By.cssSelector(".review-action svg:nth-of-type("+rating+")")).click();
            return new ReviewPage(driver);
        }


}
