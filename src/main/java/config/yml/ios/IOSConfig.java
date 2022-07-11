package config.yml.ios;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class IOSConfig {

    @JsonProperty("app")
    private String appPath;

    @JsonProperty("devices")
    private List<IOSDeviceConfig> iosDevices;


    public IOSDeviceConfig getDeviceById(String deviceId) {
        return iosDevices.stream()
                .filter(device -> device.getId().equalsIgnoreCase(deviceId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No such id"));
    }
}
