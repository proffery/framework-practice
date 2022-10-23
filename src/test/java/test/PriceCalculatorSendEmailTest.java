package test;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CleanCalculatorPage;
import page.CloudHomePage;
import page.PostPage;


public class PriceCalculatorSendEmailTest extends CommonConditions {
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String INSTANCES = "4";

    @Test
    public void priceCompare() {
        String calcPageWindow = driver.getWindowHandle();

        String postEmail = new CloudHomePage(driver)
                .openPage()
                .searchPricingCalculator(SEARCH_REQUEST)
                .openCalcPage()
                .redirectionToActualFrame()
                .fillCalcForm(INSTANCES)
                .createPostTab()
                .goToPostPage()
                .getEmail();

        String postPageWindow = driver.getWindowHandle();

        String costOnPage = new PostPage(driver)
                .switchToTab(calcPageWindow)
                .sendEmail(postEmail)
                .getPrice();

        String costInMail = new CleanCalculatorPage(driver)
                .switchToTab(postPageWindow)
                .getPriceFromEmail();

        Assert.assertTrue(costOnPage.contains(costInMail));
    }
}
