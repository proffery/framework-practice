package service;

import model.Engine;
import org.openqa.selenium.WebDriver;

public class EngineCreator {
    private final WebDriver driver;
    private static final String TEST_ENGINE_INSTANCES = TestDataReader.getTestData("test.engine.instances");
    private static final String TEST_ENGINE_SOFTWARE = TestDataReader.getTestData("test.engine.software");
    private static final String TEST_ENGINE_PROVISIONING = TestDataReader.getTestData("test.engine.provisioning");
    private static final String TEST_ENGINE_SERIES = TestDataReader.getTestData("test.engine.series");
    private static final String TEST_ENGINE_MACHINE = TestDataReader.getTestData("test.engine.machine");
    private static final String TEST_ENGINE_GPU_TYPE = TestDataReader.getTestData("test.engine.gpu.type");
    private static final String TEST_ENGINE_GPU_NUMBER = TestDataReader.getTestData("test.engine.gpu.number");
    private static final String TEST_ENGINE_LOCATION = TestDataReader.getTestData("test.engine.location");
    private static final String TEST_ENGINE_SSD = TestDataReader.getTestData("test.engine.ssd");

    private static final String TEST_ENGINE_USAGE = TestDataReader.getTestData("test.engine.usage");

    public EngineCreator(WebDriver driver) {
        this.driver = driver;
    }

    public Engine fromProperties() {


        return new Engine(TEST_ENGINE_INSTANCES, TEST_ENGINE_SOFTWARE, TEST_ENGINE_PROVISIONING, TEST_ENGINE_SERIES,
                TEST_ENGINE_MACHINE, TEST_ENGINE_LOCATION, TEST_ENGINE_GPU_TYPE, TEST_ENGINE_GPU_NUMBER, TEST_ENGINE_SSD,
                TEST_ENGINE_USAGE);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
