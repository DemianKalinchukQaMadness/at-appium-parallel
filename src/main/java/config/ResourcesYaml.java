package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.yml.android.AndroidConfig;
import config.yml.ios.IOSConfig;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

@Getter
public class ResourcesYaml {

    private IOSConfig iosConfig;
    private AndroidConfig androidConfig;
    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public ResourcesYaml() {
        try {
            this.iosConfig = mapper.readValue(new File("src/main/resources/ios_config.yml"), IOSConfig.class);
            this.androidConfig = mapper.readValue(new File("src/main/resources/android_config.yml"), AndroidConfig.class);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
