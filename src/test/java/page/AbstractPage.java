package page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final int POLLING_TIMEOUT_SECONDS = 2;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
