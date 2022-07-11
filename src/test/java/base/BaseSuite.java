package base;

import config.ResourcesYaml;
import org.testng.annotations.BeforeSuite;

public class BaseSuite {

    protected ResourcesYaml resourcesYaml;

    @BeforeSuite(alwaysRun = true)
    public void setupConfig() {
        resourcesYaml = new ResourcesYaml();
    }
}
