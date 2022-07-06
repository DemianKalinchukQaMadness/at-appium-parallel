package appConfig;

import com.google.common.annotations.Beta;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Beta
public class ResourcesConfig extends Properties {

    private String propertiesFilePath;

    public ResourcesConfig() {
        super(new Properties());
    }

    public ResourcesConfig(String propertiesPath) {
        this();
        this.propertiesFilePath = Resources.getResource(propertiesPath).getPath();
    }

    public ResourcesConfig(String propertiesPath,
                           String platform) {
        super(new Properties());
        this.propertiesFilePath = Resources.getResource(platform + "/" + propertiesPath).getPath();
    }

    public void load() {
        try {
            this.load(Files.newInputStream(Paths.get(propertiesFilePath)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
