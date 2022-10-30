package model;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Engine {

    private final String instances;
    private final WebElement software;
    private final WebElement provisioning;
    private final WebElement series;
    private final WebElement machine;
    private final WebElement location;
    private final WebElement gpuType;
    private final WebElement numberOfGpu;
    private final WebElement ssd;
    private final WebElement usage;

    public Engine(String instances, WebElement software, WebElement provisioning, WebElement series, WebElement machine,
                  WebElement location, WebElement gpuType, WebElement numberOfGpu, WebElement ssd, WebElement usage) {
        this.instances = instances;
        this.software = software;
        this.provisioning = provisioning;
        this.series = series;
        this.machine = machine;
        this.location = location;
        this.gpuType = gpuType;
        this.numberOfGpu = numberOfGpu;
        this.ssd = ssd;
        this.usage = usage;
    }

    public String getInstances() {
        return instances;
    }

    public WebElement getSoftware() {
        return software;
    }

    public WebElement getProvisioning() {
        return provisioning;
    }

    public WebElement getSeries() {
        return series;
    }

    public WebElement getMachine() {
        return machine;
    }

    public WebElement getLocation() {
        return location;
    }

    public WebElement getGpuType() {
        return gpuType;
    }

    public WebElement getNumberOfGpu() {
        return numberOfGpu;
    }

    public WebElement getSsd() {
        return ssd;
    }

    public WebElement getUsage() {
        return usage;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "instances='" + instances + '\'' +
                "software='" + software.getText() + '\'' +
                "provisioning='" + provisioning.getText() + '\'' +
                "series='" + series.getText() + '\'' +
                "gpuType='" + gpuType.getText() + '\'' +
                "numberOfGpu='" + numberOfGpu.getText() + '\'' +
                "location='" + location.getText() + '\'' +
                "ssd='" + ssd.getText() + '\'' +
                "usage='" + usage.getText() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return instances.equals(engine.instances) && software.equals(engine.software) && provisioning.equals(engine.provisioning) && series.equals(engine.series) && machine.equals(engine.machine) && location.equals(engine.location) && gpuType.equals(engine.gpuType) && numberOfGpu.equals(engine.numberOfGpu) && ssd.equals(engine.ssd) && usage.equals(engine.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, software, provisioning, series, machine, location, gpuType, numberOfGpu, ssd, usage);
    }
}
