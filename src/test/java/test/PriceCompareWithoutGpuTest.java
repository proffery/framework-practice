package test;
import model.Engine;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CalculatorPage;
import page.CloudHomePage;
import page.PostPage;
import service.EngineCreator;


public class PriceCompareWithoutGpuTest extends CommonConditions {

    @Test
    public void priceCompareWithoutGpu() {

        new CloudHomePage(driver)
                .openPage()
                .searchPricingCalculator()
                .openCalcPage();

        String calcPageWindow = driver.getWindowHandle();

        Engine engine = new EngineCreator(driver).fromProperties();

        String postEmail = new CalculatorPage(driver)
                .fillEngineFormWithoutGpu(engine)
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
