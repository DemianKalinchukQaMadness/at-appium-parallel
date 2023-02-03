package config.yml.ios;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IOSDeviceConfig extends IOSConfig {

    @JsonProperty("deviceId") private String id;
    @JsonProperty("deviceName") private String deviceName;
    @JsonProperty("platformVersion") private String version;
    @JsonProperty("devicePort") private int devicePort;
    @JsonProperty("udid") private String udid;
    @JsonProperty("app") private String appPath;
}
