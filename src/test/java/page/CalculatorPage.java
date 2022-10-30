package page;
import model.Engine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends AbstractPage {

    @FindBy(xpath = "//md-tab-item/div[@class='tab-holder compute' and @title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//md-input-container/input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-min ng-invalid ng-invalid-required' and @name='quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//*[contains(@aria-label,'Operating')]/md-select-value/span[@class='md-select-icon']")
    private WebElement softwareOpen;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']/md-select-value/span[@class='md-select-icon']")
    private WebElement provisioningOpen;

    @FindBy(xpath = "//md-select[@name='series']/md-select-value/span[@class='md-select-icon']")
    private WebElement seriesOpen;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']/md-select-value/span[@class='md-select-icon']")
    private WebElement machineTypeOpen;


    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGpu;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'GPU type')]")
    private WebElement gpuTypeOpen;


    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Number of GPUs')]")
    private WebElement numberOfGpuOpen;


    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Datacenter location')]//span[@class='md-select-icon']")
    private WebElement locationOpen;

    @FindBy(xpath = "//div[@ng-if=\"listingCtrl.checkLocalSsdAvailibility('computeServer')\"]//md-select[starts-with(@aria-label,'Local SSD')]//span[@class='md-select-icon']")
    private WebElement ssdOpen;

    @FindBy(xpath = "//md-select[starts-with(@aria-label,'Committed usage')]//span[@class='md-select-icon']")
    private WebElement usageOpen;

    @FindBy(xpath = "//button[starts-with(@ng-disabled,'ComputeEngineForm.$invalid')]")
    private WebElement addButton;

    @FindBy(xpath = "//*[contains(text(),'Total Estimated Cost')]")
    private WebElement priceResult;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailButton;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);

    }
    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException();
    }

    public CalculatorPage fillEngineFormWithGpu(Engine engine) {
        computeEngineButton.click();
        numberOfInstancesField.sendKeys(engine.getInstances());
        softwareOpen.click();
        engine.getSoftware().click();
        provisioningOpen.click();
        engine.getProvisioning().click();
        seriesOpen.click();
        engine.getSeries().click();
        machineTypeOpen.click();
        engine.getMachine().click();
        locationOpen.click();
        engine.getLocation().click();
        addGpu.click();
        gpuTypeOpen.click();
        engine.getGpuType().click();
        numberOfGpuOpen.click();
        engine.getNumberOfGpu().click();
        ssdOpen.click();
        engine.getSsd().click();
        usageOpen.click();
        engine.getUsage().click();
        addButton.click();
        return this;
    }


    public CalculatorPage sendEmail(String email) {
        emailButton.click();
        emailField.sendKeys(email);
        sendEmailButton.click();
        return this;
    }

    public PostPage switchToTab(String windowHandle) {
        driver.switchTo().window(windowHandle);
        return new PostPage(driver);
    }
    public PostPage createNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        return new PostPage(driver);
    }
    public String getPrice() {
        return priceResult.getText();
    }
}
