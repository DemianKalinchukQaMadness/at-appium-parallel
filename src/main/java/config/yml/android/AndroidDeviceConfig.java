package config.yml.android;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AndroidDeviceConfig {

    @JsonProperty("deviceId")
    private String id;

    @JsonProperty("deviceName")
    private String deviceName;

    @JsonProperty("platformVersion")
    private String version;

    @JsonProperty("devicePort")
    private int devicePort;

}
