package config.yml.ios;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IOSDeviceConfig {

    @JsonProperty("deviceId")
    private String id;

    @JsonProperty("deviceName")
    private String deviceName;

    @JsonProperty("platformVersion")
    private String version;

    @JsonProperty("devicePort")
    private int devicePort;

    @JsonProperty("udid")
    private String udid;
}
