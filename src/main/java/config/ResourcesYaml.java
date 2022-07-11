package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Resources;
import config.yml.android.AndroidConfig;
import config.yml.ios.IOSConfig;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

@Getter
public class ResourcesYaml {

    private File androidFile;
    private File iosFile;
    private IOSConfig iosConfig;
    private AndroidConfig androidConfig;
    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public ResourcesYaml() {
        try {
            this.androidFile = new File(Resources.getResource("android_config.yml").getPath());
            this.iosFile = new File(Resources.getResource("ios_config.yml").getPath());
            this.iosConfig = mapper.readValue(iosFile, IOSConfig.class);
            this.androidConfig = mapper.readValue(androidFile, AndroidConfig.class);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
