package model;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Engine {

    private final String instances;
    private final String software;
    private final String provisioning;
    private final String series;
    private final String machine;
    private final String location;
    private final String gpuType;
    private final String numberOfGpu;
    private final String ssd;
    private final String usage;

    public Engine(String instances, String software, String provisioning, String series, String machine,
                  String location, String gpuType, String numberOfGpu, String ssd, String usage) {
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

    public String getSoftware() {
        return software;
    }

    public String getProvisioning() {
        return provisioning;
    }

    public String getSeries() {
        return series;
    }

    public String getMachine() {
        return machine;
    }

    public String getLocation() {
        return location;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public String getSsd() {
        return ssd;
    }

    public String getUsage() {
        return usage;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "instances='" + instances + '\'' +
                "software='" + software + '\'' +
                "provisioning='" + provisioning + '\'' +
                "series='" + series + '\'' +
                "gpuType='" + gpuType + '\'' +
                "numberOfGpu='" + numberOfGpu + '\'' +
                "location='" + location + '\'' +
                "ssd='" + ssd + '\'' +
                "usage='" + usage + '\'' +
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
