package page;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.StringUtil;

import java.time.Duration;

public class SearchResultsPage extends AbstractPage {
    private static final String IFRAME_LINKS = "//iframe[@src]";
    private static final String FRAME_PATTERN_ONE = "https://cloud.google.com/products/calculator/";
    private static final String FRAME_PATTERN_TWO = "https://cloudpricingcalculator.appspot.com";
    private static final String LINC_ATTRIBUTE = "src";

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator' and @class='gs-title']")
    private WebElement calcInResults;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }
    public CalculatorPage openCalcPage() {

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .pollingEvery(Duration.ofSeconds(POLLING_TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(calcInResults))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds( WAIT_TIMEOUT_SECONDS));
        driver.navigate().to(StringUtil.actualLincFrame(driver,FRAME_PATTERN_ONE,IFRAME_LINKS,LINC_ATTRIBUTE));

        new WebDriverWait(driver, Duration.ofSeconds( WAIT_TIMEOUT_SECONDS));
        driver.navigate().to(StringUtil.actualLincFrame(driver,FRAME_PATTERN_TWO,IFRAME_LINKS,LINC_ATTRIBUTE));

        return new CalculatorPage(driver);
    }

}
