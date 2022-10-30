package test;
import model.Engine;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CalculatorPage;
import page.CloudHomePage;
import page.PostPage;
import sevice.EngineCreator;


public class PriceCalculatorSendEmailTest extends CommonConditions {

    @Test
    public void priceCompare() {

        new CloudHomePage(driver)
                .openPage()
                .searchPricingCalculator()
                .openCalcPage();

        String calcPageWindow = driver.getWindowHandle();

        Engine engineFromHardcore = new EngineCreator(driver).withCredentialsFromHardcore();

        String postEmail = new CalculatorPage(driver)
                .fillEngineFormWithGpu(engineFromHardcore)
                .createNewTab()
                .goToPostPage()
                .getRandomEmail();

        String postPageWindow = driver.getWindowHandle();

        String costOnPage = new PostPage(driver)
                .switchToTab(calcPageWindow)
                .sendEmail(postEmail)
                .getPrice();

        String costInMail = new CalculatorPage(driver)
                .switchToTab(postPageWindow)
                .getPriceFromEmail();

        Assert.assertTrue(costOnPage.contains(costInMail));
    }
}
