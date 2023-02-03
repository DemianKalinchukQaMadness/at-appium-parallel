package config.yml.ios;

import com.fasterxml.jackson.annotation.JsonProperty;
import config.yml.PlatformConfig;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IOSConfig implements PlatformConfig {

    @JsonProperty("devices") private List<IOSDeviceConfig> iosDevices;

    public IOSDeviceConfig getDeviceById(String deviceId) {
        return iosDevices.stream()
                .filter(device -> device.getId().equalsIgnoreCase(deviceId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No such id"));
    }
}
