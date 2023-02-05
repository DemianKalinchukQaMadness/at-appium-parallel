package config.yml.android;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AndroidConfig {

    @JsonProperty("devices") private List<AndroidDeviceConfig> androidDevices;

    public AndroidDeviceConfig getDeviceById(String deviceId) {
        return androidDevices.stream()
                .filter(device -> device.getId().equalsIgnoreCase(deviceId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No such id"));
    }
}
