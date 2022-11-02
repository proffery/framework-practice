package page;
import model.Engine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getSoftware())))).click();
        provisioningOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getProvisioning())))).click();
        seriesOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getSeries())))).click();
        machineTypeOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getMachine())))).click();
        locationOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getLocation())))).click();
        addGpu.click();
        gpuTypeOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getGpuType())))).click();
        numberOfGpuOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getNumberOfGpu())))).click();
        ssdOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getSsd())))).click();
        usageOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getUsage())))).click();
        addButton.click();
        logger.info("Filling calc form");
        return this;
    }

    public CalculatorPage fillEngineFormWithoutGpu(Engine engine) {
        computeEngineButton.click();
        numberOfInstancesField.sendKeys(engine.getInstances());
        softwareOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getSoftware())))).click();
        provisioningOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getProvisioning())))).click();
        seriesOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getSeries())))).click();
        machineTypeOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getMachine())))).click();
        locationOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getLocation())))).click();
        ssdOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getSsd())))).click();
        usageOpen.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(engine.getUsage())))).click();
        addButton.click();
        logger.info("Filling calc form");
        return this;
    }

    public CalculatorPage sendEmail(String email) {
        emailButton.click();
        emailField.sendKeys(email);
        sendEmailButton.click();
        logger.info("Sending email");
        return this;
    }

    public PostPage switchToTab(String windowHandle) {
        driver.switchTo().window(windowHandle);
        logger.info("Switching to tab");
        return new PostPage(driver);
    }
    public PostPage createNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        logger.info("Creating new tab");
        return new PostPage(driver);
    }
    public String getPrice() {
        String price = priceResult.getText();
        logger.info("Getting price from calculator page:" + price);
        return price;
    }
}
