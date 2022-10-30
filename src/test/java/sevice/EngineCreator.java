package sevice;

import model.Engine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngineCreator {
    private WebDriver driver;
    private static final String INSTANCES_FROM_HARDCORE = "4";

    @FindBy(xpath = "//md-option/*[contains(text(),'Free: Debian,')]")
    private WebElement softwareFree;


    @FindBy(xpath = "//md-option/div[text()='Regular']")
    private WebElement regularProvisioning;


    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement n1Series;


    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div")
    private WebElement n1Standard8Machine;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_P100']/div")
    private WebElement teslaP100GpuType;


    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value ='1']")
    private WebElement numberOfGpuIsOne;

    @FindBy(xpath = "//md-select-menu[@class='md-overflow']//md-option[@value='europe-west3']")
    private WebElement locationIsFrankfurt;


    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer']/div[contains(text(),'2x375 GB')]")
    private WebElement ssdIs2X375;


    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'1 Year')]")
    private WebElement usageIsOneYear;

    public EngineCreator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Engine withCredentialsFromHardcore() {
        return new Engine(INSTANCES_FROM_HARDCORE, softwareFree, regularProvisioning, n1Series,
                n1Standard8Machine, locationIsFrankfurt, teslaP100GpuType, numberOfGpuIsOne, ssdIs2X375,
                usageIsOneYear);
    }

}
