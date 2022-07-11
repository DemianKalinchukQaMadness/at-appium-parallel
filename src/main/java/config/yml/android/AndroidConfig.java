package config.yml.android;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AndroidConfig {

    @JsonProperty("app")
    private String appPath;

    @JsonProperty("devices")
    private List<AndroidDeviceConfig> androidDevices;

    public AndroidDeviceConfig getDeviceById(String deviceId) {
        return androidDevices.stream()
                .filter(device -> device.getId().equalsIgnoreCase(deviceId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No such id"));
    }
}
