package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Resources;
import config.yml.android.AndroidConfig;
import config.yml.ios.IOSConfig;
import driver.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@Getter
@NoArgsConstructor
public class ResourcesYaml {

    private File file;
    private IOSConfig iosConfig;
    private AndroidConfig androidConfig;
    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    public ResourcesYaml(String platform) {
        try {
            Platform mobilePlatform = Platform.valueOf(platform.toUpperCase());
            this.file = new File(Resources.getResource(platform + "_config.yml").getPath());

            switch (mobilePlatform) {
                case IOS:
                    this.iosConfig = mapper.readValue(file, IOSConfig.class);
                    break;

                case ANDROID:
                    this.androidConfig = mapper.readValue(file, AndroidConfig.class);
                    break;

                default:
                    throw new IllegalStateException(
                            "Platform not supported! Check if you set ios or android on the parameter.");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
