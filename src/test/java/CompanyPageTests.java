import Pages.ReviewPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class CompanyPageTests extends BaseTests{
    public final int rating=4;
    public final String review="There is a multitude of different types of insurance policies available, and virtually any individual" +
            "or business can find an insurance company willing to insure " +
            "them—for a price. The most common types of personal insurance policies are auto, health, homeowners, and life." ;



    @Test
    public void test_verifyTheStarColourOnHover(){
        String[] starList= {"#4ae0e1", "#4ae0e1", "#4ae0e1", "#4ae0e1", "#4ae0e1"};
        List<String> expextedResult= Arrays.asList(starList);
        assertEquals(homePage.getCompanyPage().verifyStarColour(),expextedResult);
    }

    @Test
   public void test_verifyReviewText(){
       ReviewPage reviewPage= homePage.getCompanyPage().rateCompany(rating);
       String reviewText=reviewPage.reviewCompany(review);
        assertEquals(reviewText ,review);
   }
}
